import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import java.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Drawer {

    private int x, y, w, h;
    private String type;

    public Drawer(int newX, int newY, int newW, int newH) {
        x = newX;
        y = newY;
        w = newW;
        h = newH;
    }

    public Drawer(int newX, int newY, int newW, int newH, String t) {
        x = newX;
        y = newY;
        w = newW;
        h = newH;
        type = t;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public String getType() {
        return type;
    }

    public void setX(int newX) {
        x = newX - getW(); // -getW/2 if top corner is needed
    }

    public void setY(int newY) {
        y = newY - getH();// -getH/2 if top corner is needed
    }

    public void setW(int newW) {
        w = newW;
    }

    public void setH(int newH) {
        h = newH;
    }

    public void incrementX(int i) {
        x += i;
    }

    public void incrementY(int i) {
        y += i;
    }

    public void incrementW(int i) {
        w += i;
    }

    public void incrementH(int i) {
        h += i;
    }

    public void travelVector(int x, int y, int m) {
        System.out.println((int) ((double) x / (double) gcd(x, y)) + ", " + (int) ((double) y / (double) gcd(x, y)));

        incrementX((int) ((double) x / (double) gcd(x, y)));
        incrementY((int) ((double) y / (double) gcd(x, y)));
    }

    public void rect(Graphics g, Color c, boolean filled) {
        type = "rect";
        g.setColor(c);
        if (filled) {
            g.fillRect(getX(), getY(), getW(), getH());
        } else {
            g.drawRect(getX(), getY(), getW(), getH());// g.drawRect(getX(), getY(), getW(), getH());
        }
    }

    public void clear(Graphics g) {
        g.setColor(Color.black);
        // g.drawRect(1, 1, 1, 1);
    }

    public void oval(Graphics g, Color c, boolean filled) {
        type = "oval";
        g.setColor(c);
        if (filled) {
            g.fillOval(getX() - (getW() / 2), getY() - (getH() / 2), getW(), getH());
        } else {
            g.drawOval(getX() - (getW() / 2), getY() - (getH() / 2), getW(), getH());
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);

    }

}
