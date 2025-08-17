import java.util.*;
import java.util.concurrent.*;


class MyCallable implements Callable<String> { 
  private final String name; 
    
  public MyCallable(String name) { 
    this.name = name; 
  } 

  @Override 
  public String call() throws Exception { 
    StringBuilder result = new StringBuilder(); 
    for (int i = 0; i < 5; i++) { 
      result.append("Callable ").append(name) 
            .append(" is running: ").append(i).append("n\n"); 
      Thread.sleep(500);
    } 
    return result.toString();
  } 
}


class BatchDispatcher{
  private BlockingQueue<FutureTask<String>> queue;
  private List<FutureTask<String>> batch;
  private int batchSize = 5;
  private int timeOut = 2;
  ExecutorService executor;
  public BatchDispatcher(){
    this.queue = new LinkedBlockingQueue<>();
    executor = Executors.newFixedThreadPool(5);
    batch = new ArrayList<>();
    
    Thread executionThread = new Thread(() -> {
      while (true) {
        try {
          FutureTask<String> firstJob = queue.take();
          long startTime = System.currentTimeMillis();
          batch.add(firstJob);
          while(batch.size() < batchSize){
            long elapsed = (System.currentTimeMillis() - startTime)/1000;
            long remaining = timeOut - elapsed;
            if(remaining <= 0) break;
            FutureTask<String> job = queue.poll(remaining, TimeUnit.SECONDS);
            if(job != null){
              batch.add(job);
            }
          }
          if(!batch.isEmpty()){
            for (FutureTask<String> task : batch) {
              executor.execute(task);
            }
          }
        }catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
    executionThread.setDaemon(true);
    executionThread.start();
  }

  public void setBatchSize(int batchSize){
    this.batchSize = batchSize;
  }

  public void setTimeOut(int timeOut){
    this.timeOut = timeOut;
  }

  public FutureTask<String> addJob(int i){
    Callable<String> callable = new MyCallable("Task-"+Integer.toString(i));
    FutureTask<String> future = new FutureTask<>(callable);
    queue.add(future);
    return future;
  }
}


public class BatchProcessingTake{
  public static void main(String arg[]){
    BatchDispatcher dispatcher = new BatchDispatcher();
    List<FutureTask<String>> futures = new ArrayList<>();
    for(int i = 1; i < 40;i++){
      futures.add(dispatcher.addJob(i));
    }
    for(FutureTask<String> future: futures){
      try{
        System.out.println(future.get());
        System.out.println("\n\n\n");
      }catch(Exception e){
        System.out.println("Exception: "+ e.getMessage());
      }
    }
  }
}