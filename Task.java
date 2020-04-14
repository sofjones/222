import java.util.Random;
public class Task implements Runnable {
  private int taskNum;

  //each task given specific taskNum
  public Task(int taskNum) {
	this.taskNum = taskNum;		
  }

  @Override
  public void run() {
    //each task sleeps between half a second and a second and then prints complete
    Random r = new Random();
    int random = r.nextInt((900-500) + 1)+500;
    try {
      Thread.sleep(random);
      System.out.println(taskNum + " complete");
     }
     catch(InterruptedException e){
       e.printStackTrace();
     }
  }
}
