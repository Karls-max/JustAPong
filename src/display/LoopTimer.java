package justAPong.display;

public class LoopTimer {

  private final double DEFAULT_FPS = 60.0;

  private long lastTime, currentTime;
  private double amountOfTime;

  public LoopTimer() {

    initTimer();
    setTimer(DEFAULT_FPS);
  } 

  public synchronized void setTimer(double counter) {

    amountOfTime = 1000000000 / counter;
  }

  public synchronized void initTimer() {

    lastTime = System.nanoTime();
  }

  public synchronized boolean endTimer() {
	
    currentTime = System.nanoTime();
	
    if(((currentTime - lastTime)/amountOfTime) >= 1) {

      lastTime = currentTime;
      return true;
    }else{

      return false;
    }
  }
}
