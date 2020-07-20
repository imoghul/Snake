import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Game {

    ArrayList<ArrayList<Drawer>> board = new ArrayList<>();
    ArrayList<Point> snake = new ArrayList<>();

    public Game() {
        for (int i = 0; i <= (Main.displayW / 20) * (Main.displayH / 20); i++) {
            snake.add(new Point());
        }
        snake.set(0, new Point(0, 0));

        for (int i = 0; i < Main.displayW / 20; i++) {
            board.add(new ArrayList(Main.displayH / 20));
            for (int j = 0; j < Main.displayH / 20; j++) {
                board.get(i).add(new Drawer(i * 20, j * 20, 20, 20));
            }
        }
    }

    public void setUnit(Graphics g, Color c, int x, int y, boolean s) {
        if (!isOut()) {
            board.get(x).get(y).rect(g, c, s);
        }

    }

    public void clearUnit(Graphics g, int x, int y) {
        if (!isOut(x, y)) {

            board.get(x).get(y).clear(g);
        }

    }

    public void drawSnake(Graphics g, int len) {
        updateSnake();
        for (int i = len - 1; i >= 0; i--) {
            if (i != 0) {
                setUnit(g, Color.white, snake.get(i).x, snake.get(i).y, true);
            } else {
                setUnit(g, Color.green, snake.get(i).x, snake.get(i).y, true);
            }

        }
        // for (int i = len; i < snake.size(); i++) {
        // clearUnit(g, snake.get(i).x, snake.get(i).y);
        // }
    }

    public boolean isOut() {
        return ((Main.headX < 0 || Main.headX >= board.size() || Main.headY < 0 || Main.headY >= board.get(0).size()));
    }

    public boolean isOut(int x, int y) {
        return ((x < 0 || x >= board.size() || y < 0 || y >= board.get(0).size()));
    }

    public Drawer getHead() {

        if (!isOut()) {
            return board.get(Main.headX).get(Main.headY);
        } else {
            return board.get(0).get(0);
        }
    }

    public void updateSnake() {
        if (!(snake.get(0).x == Main.headX && snake.get(0).y == Main.headY)) {
            for (int i = (snake.size() - 1); i > 0; i--) {
                snake.set(i, snake.get(i - 1));
            }
            snake.set(0, new Point(Main.headX, Main.headY));
        }
    }

    public void reset() {
        Main.headX = 0;
        Main.headY = 0;
        Main.velocityX = 0;
        Main.velocityY = 0;
        Main.snakeLen = 1;
        Main.counterSpeed = Main.defaultSpeed;
        System.out.println("LOSE");
    }

    public void painter(Graphics g){
        
    }
}