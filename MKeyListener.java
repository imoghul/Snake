import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.reflect.Field;

public class MKeyListener extends KeyAdapter {
    boolean toggle = false;

    public void keyPressed(KeyEvent event) {
        char ch = event.getKeyChar();
        // System.out.println(event.getKeyChar() + "'s code is: " + event.getKeyCode());
        switch (event.getKeyCode()) {
        case 38:// UP
            if (!Main.isOUT) {
                Main.velocityY = -1;
                Main.velocityX = 0;
            }
            break;
        case 40:// DOWN
            if (!Main.isOUT) {
                Main.velocityY = 1;
                Main.velocityX = 0;
            }
            break;
        case 39:// RIGHT
            if (!Main.isOUT) {
                Main.velocityX = 1;
                Main.velocityY = 0;
            }
            break;
        case 37:// LEFT
            if (!Main.isOUT) {
                Main.velocityX = -1;
                Main.velocityY = 0;
            }
            break;

        }

    }

}