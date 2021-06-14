package justAPong.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Window extends Canvas{

  private JFrame jframe;
	
  public Window(String title, int width, int height) {

    setPreferredSize(new Dimension(width, height));
    setMaximumSize(new Dimension(width, height));
    setMinimumSize(new Dimension(width, height));
    setFocusable(false);
		
    jframe = new JFrame(title);
    jframe.add(this);
    jframe.pack();
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
    jframe.setResizable(false);
    jframe.setLocationRelativeTo(null);
    jframe.setVisible(true);
  }

  public BufferStrategy getBS(){

    return getBufferStrategy();
  }

  public void createBS(){

    createBufferStrategy(3);
  }

  public void setKL(KeyListener kL){

    jframe.addKeyListener(kL);
  }
}
