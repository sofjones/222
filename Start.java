//Starting class sets up task pool and starts and joins threads
public class Start {
  public static int numThreads = 4;
  public static TaskPool taskpool;

  public static void main(String [] args) {
    
    MyThread[] threads = new MyThread[numThreads];
    taskpool = new TaskPool(5);

    //tasks created and added to task pool
    Task r0 = new Task(0);
    taskpool.addTask(r0,0);

    Task r1 = new Task(1);
    taskpool.addTask(r1,1);	

    Task r2 = new Task(2);
    taskpool.addTask(r2,2);

    Task r3 = new Task(3);
    taskpool.addTask(r3,3);

    for(int i = 0; i< threads.length;i++) {
      threads[i] = new MyThread(i);
      threads[i].start();
     }

     for(int i = 0; i < threads.length; i++) {
       try {
	threads[i].join();
       }
       catch(InterruptedException e) {
         e.printStackTrace();
	}
     }
   }
}	
