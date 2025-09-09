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
                  .append(" is running: ").append(i).append("n"); 
            Thread.sleep(500);
        } 
        return result.toString();
    } 
}
 
public class CallableExample { 
    public static void main(String[] args) { 
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<String> callable1 = new MyCallable("Task 1"); 
        Callable<String> callable2 = new MyCallable("Task 2"); 
         
        try {
            Future<String> future1 = executor.submit(callable1); 
            Future<String> future2 = executor.submit(callable2);
            System.out.println("Result from first task:"); 
            System.out.println(future1.get());
             
            System.out.println("Result from second task:"); 
            System.out.println(future2.get());
             
        } catch (InterruptedException | ExecutionException e) { 
            System.out.println("Task execution interrupted: " + e.getMessage()); 
        } finally { 
            executor.shutdown(); 
        } 
    } 
}