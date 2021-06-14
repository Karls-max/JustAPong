package justAPong.display;

public class LoopTimer {

  private final double DEFAULT_FPS = 60.0;

  private long lastTime, currentTime;
  private double amountOfTime;

  public LoopTimer() {

    initTimer();
    setCounter(DEFAULT_FPS);
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
