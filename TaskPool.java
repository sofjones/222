//simple implementation of task pool 
public class TaskPool {
  private int numThreads;
  public static Task taskPool[];

  //creates a new task pool with the same amount of tasks as threads
  public TaskPool(int numThreads) {
    this.numThreads = numThreads;
    taskPool = new Task[numThreads];
  }

  //add tasks to pool
  public void addTask(Task t, int taskNum) {
    taskPool[taskNum] = t;
  }

  //returns a specific task
  public static Task getTask(int taskNum) {
    return taskPool[taskNum];
  }
}	
