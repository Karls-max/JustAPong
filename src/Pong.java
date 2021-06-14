package justAPong;

import justAPong.display.*;

public class Pong implements Runnable {

  private Window window;
  private Thread thread;
  private LoopTimer pongLoop;
  private boolean isRunning = false;

  public static final int WIDTH = 270, HEIGHT = 180;
  public static int scale = 3;

  private LoopTimer testTimer;//test

  public Pong() {
    
    pongLoop = new LoopTimer();
    pongLoop.setCounter(2.0);
    testTimer = new LoopTimer();//test
    testTimer.setTimer(2.0);//test
    window = new Window("Pong", WIDTH*scale, HEIGHT*scale);
  }

  public synchronized void start() {

    isRunning = true;

    thread = new Thread(this);
    thread.start();
  }

  public synchronized void stop() {

    isRunning = false;

    try {

      thread.join();
    }catch(InterruptedException e) {

      e.printStackTrace();
    }
  }

  public void run(){

    while(isRunning){

      if(pongLoop.endTimer(false)){
                
          logic();
                
          render();
      }
    }

    stop();
  }

  private void logic() {

    System.out.println("hello there");//test
    if(testTimer.endTimer(false)){//test
      System.out.println("hi");//test
    }
  }

  private void render() {

  }

}
