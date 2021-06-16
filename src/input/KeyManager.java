package justAPong.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

  private boolean[] keyState = new boolean[256];
  public static boolean w, s, a, d, up, down, left, right, esc, space;

  public void keyUpdate(){

    w = keyState[KeyEvent.VK_W];
    s = keyState[KeyEvent.VK_S];
    a = keyState[KeyEvent.VK_A];
    d = keyState[KeyEvent.VK_D];
    up = keyState[KeyEvent.VK_UP];
    down = keyState[KeyEvent.VK_DOWN];
    left = keyState[KeyEvent.VK_LEFT];
    right = keyState[KeyEvent.VK_RIGHT];
    esc = keyState[KeyEvent.VK_ESCAPE];
    space = keyState[KeyEvent.VK_SPACE];
  }

  public void keyPressed(KeyEvent key) {

    if (key.getKeyCode() < 0 || key.getKeyCode() > 255){
      return;
    }
    keyState[key.getKeyCode()] = true;
  }

  public void keyReleased(KeyEvent key) {

    if (key.getKeyCode() < 0 || key.getKeyCode() > 255){

      return;
    }

    keyState[key.getKeyCode()] = false;
  }

  public void keyTyped(KeyEvent key){

  }
}
