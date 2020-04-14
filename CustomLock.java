//custom lock class to support mutual exclusion
public class CustomLock {
  public static int numThreads = 4;
  public static volatile int count = 0;
  public static TaskPool taskpool;
  /**
  *turn represents a true or false value if it is a threads turn or not
  *priority is the order which each thread runs
  *priority is found by adding one to the priority of the thread before it
  */
  private static volatile boolean[] turn = new boolean[numThreads];
  private static volatile int[] priority = new int[numThreads];
 
  //lock method to secure a thread runs, start of mutual exclusion 
  public void lock(int label) {
    //turn is set to true and priority is found
    turn[label] = true;
    priority[label] = findCount() + 1;

    //turn is now set to false after priority has been set
    turn[label] = false;

      for(int i = 0; i< numThreads;i++) {
        //if thread is current thread move on to next
	if(i == label) {
	  continue;
	}

	//do nothing if the priority is not 0 and less than the thread label passed into method
	while(priority[i] != 0 && (priority[label] >  priority[i] || (priority[label] == priority[i] && label > i))) {
	}
      }
  }

  //method releasing lock and setting priority to 0 so thread does not run again 
  public void unlock(int label) {
    priority[label] = 0;
  }

  //method for finding getting priority of each thread returns max value 
  public int findCount() {
    int x = priority[0];
    for(int i = 1; i< priority.length; i++) {
      if(priority[i] > x) {
        x = priority[i];
	}
    }
    return x;
    }
  }
