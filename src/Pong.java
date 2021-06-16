package justAPong;

import justAPong.display.*;
import justAPong.entities.*;
import justAPong.state.*;
import justAPong.input.*;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Pong implements Runnable {

  private Window window;
  private Thread thread;
  private LoopTimer pongLoop;
  private BufferedImage bufferImage;
  private boolean isRunning = false;

  private final double DEFAULT_FPS = 2.0;
  public static final int WIDTH = 480, HEIGHT = 320;

  public Pong() {
    
    pongLoop = new LoopTimer();
    pongLoop.setCounter(DEFAULT_FPS);
    window = new Window("Pong", WIDTH, HEIGHT);
    bufferImage = new BufferedImage(WIDTH, HEIGHT, 1);
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

    System.out.println("+\n-");
  }

  private void render() {

    BufferStrategy buffer = window.getBS();
    if(buffer == null){

      window.createBS();
      return;
    }

    Graphics graphic = bufferImage.getGraphics();

    graphic.setColor(new Color(0, 0, 0));
    graphic.fillRect(0, 0, WIDTH ,HEIGHT);

    graphic.setColor(new Color(230, 230, 230));
    graphic.fillRect((WIDTH/2)-2,0,4,HEIGHT);

    graphic = buffer.getDrawGraphics();
    graphic.drawImage(bufferImage, 0, 0, WIDTH, HEIGHT, null);

    graphic.dispose();
    buffer.show();
  }
}
