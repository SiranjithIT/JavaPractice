import java.util.concurrent.*;
import java.util.*;

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

public class Processing {
  public static void main(String arg[]){
    Queue<Future<String>> queue = new LinkedList<>();
    ExecutorService executor = Executors.newFixedThreadPool(5);
    for(int i = 1;i < 16;i++){
      Callable<String> callable = new MyCallable("Task-"+ Integer.toString(i));
      Future<String> future = executor.submit(callable);
      queue.add(future);
    }

    while(!queue.isEmpty()){
      Future<String> item = queue.remove();
      System.out.println("\n\nResult: ");
      try{
        System.out.println(item.get());
      }
      catch(Exception e){
        System.out.println("Exception: "+e.getMessage());
      }
    }
    executor.shutdown();
  }
}
