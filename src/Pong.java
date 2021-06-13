package justAPong;

import justAPong.display.*;

public class Pong implements Runnable {

  private Window window;
  private Thread thread;
  private LoopTimer timer;
  private boolean isRunning = false;

  public static final int WIDTH = 320, HEIGHT = 240;

  public Pong() {
    
    timer = new LoopTimer();
    timer.setFPS(1.0);
    window = new Window("Pong", WIDTH, HEIGHT);
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

    timer.initTimer();

    while(isRunning){

      if(timer.endTimer()){
                
          logic();
                
          render();
      }
    }

    stop();
  }

  private void logic() {

    System.out.println("hello there");
  }

  private void render() {

  }

}
