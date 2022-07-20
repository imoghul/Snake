package Listeners;
import java.awt.event.*;

import Features.Values;


public class KeyListen extends KeyAdapter {

    public void keyPressed(KeyEvent event) {
        int c = event.getKeyCode();

        switch (c) {
            case KeyEvent.VK_RIGHT:
                Values.snake.currDirection = Values.Directions.RIGHT;
                break;

            case KeyEvent.VK_LEFT:
                Values.snake.currDirection = Values.Directions.LEFT;
                break;

            case KeyEvent.VK_UP:
                Values.snake.currDirection = Values.Directions.UP;
                break;

            case KeyEvent.VK_DOWN:
                Values.snake.currDirection = Values.Directions.DOWN;
                break;
            default:break;
        }
    }
}
