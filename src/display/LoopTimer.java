package justAPong.display;

public class LoopTimer {

  private final double DEFAULT_FPS = 60.0;

  private long lastTime, currentTime;
  private double amountOfFPS;

  public LoopTimer() {

    initTimer();
    setFPS(DEFAULT_FPS);
  } 

  public void setFPS(double fps) {

    amountOfFPS = 1000000000 / fps;
  }

  public void initTimer() {

    lastTime = System.nanoTime();
  }

  public boolean endTimer() {
	
    currentTime = System.nanoTime();
	
    if(((currentTime - lastTime)/amountOfFPS) >= 1) {

      lastTime = currentTime;
      return true;
    }else{

      return false;
    }
  }
}
