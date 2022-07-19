package Features;
import java.awt.Color;
import Graphics.*;
import java.util.concurrent.TimeUnit;
import java.awt.Graphics;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class SimulatorRunner {

    public static void run(Graphics g) {
        Values.snake.run(g);

        try {
            TimeUnit.MILLISECONDS.sleep(Values.snake.currDirection==Values.Directions.NONE?0:Values.gameSpeed);
        } catch(Exception e) {

        }
    }



}
