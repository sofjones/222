//class for threads to call lock and unlock 
public class MyThread extends Thread {
  public static TaskPool taskpool;
  private static CustomLock myLock = new CustomLock();
  public int threadLabel;

  //each thread to be created will have a specific label
  public MyThread(int label) {
    threadLabel = label;
  }

@Override
public void run() {
	System.out.println("thread " + threadLabel + " is attempting to get the lock");
	myLock.lock(threadLabel);
	System.out.println("thread" + threadLabel + " has succesfully got the lock");
	//critical section
	try {
		System.out.println(threadLabel + " attempting to get task " + threadLabel); 
		Task task = TaskPool.getTask(threadLabel);
		task.run();
		sleep(1000);
	}catch(InterruptedException e){
	}
	System.out.println("thread " + threadLabel + " is now releasing lock");
	//releases lock for next thread, ends critical section
	myLock.unlock(threadLabel);
}
}
