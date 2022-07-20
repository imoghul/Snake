package Features;
import java.awt.Color;
import Graphics.*;
import java.util.concurrent.TimeUnit;

import Elements.Snake;

import java.awt.Graphics;

public class SimulatorRunner {
    public static void run(Graphics g) {
        int success = Values.snake.run(g);
        if(success==0){
            Values.snake = new Snake(Values.gridW, Values.gridH);
        }
        

        try {
            TimeUnit.MILLISECONDS.sleep(Values.snake.currDirection==Values.Directions.NONE?0:Values.snake.speed);
        } catch(Exception e) {

        }
    }



}
