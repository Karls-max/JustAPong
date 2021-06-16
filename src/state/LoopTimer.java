package justAPong.state;

public class LoopTimer {

  private long lastTime, currentTime;
  private double amountOfTime;

  public LoopTimer() {

    initTimer();
  } 

  public synchronized void setCounter(double counter) {

    amountOfTime = 1000000000 / counter;
  }

  public synchronized void setTimer(double timer) {

    amountOfTime = 1000000000 * timer;
  }

  public void initTimer() {

    lastTime = System.nanoTime();
  }

  public synchronized boolean endTimer(boolean stop) {
	
    currentTime = System.nanoTime();
	
    if(((currentTime - lastTime)/amountOfTime) >= 1) {

      if(!stop){

        lastTime = currentTime;
      }
      return true;
    }else{

      return false;
    }
  }
}
