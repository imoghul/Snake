package Features;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Point;
import java.awt.Image;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

import java.awt.geom.AffineTransform;

import Graphics.Mouse;
import Elements.Snake;

public class Values {
    public static int displayW, displayH, timerSpeed = 15;
    public static Color backgroundColor = Color.black;
    //
    public static int blockSize = 20;
    public static int blockGap = 1;
    public static Snake snake;
    public static int gameSpeed = 100;
    public static int gridW = 25;
    public static int gridH = 25;
    //
    public static Mouse mouse = new Mouse(Values.timerSpeed);

    public static enum  Directions {
        RIGHT,
        UP,
        DOWN,
        LEFT,
        NONE
    }
    public static void setup(Component window, Container container) {
        Values.snake = new Snake(Values.gridW, Values.gridH);
    }

    // private static void showPopup(Component c, ActionEvent ae, JPopupMenu menu) {
    //     Component b = (Component)ae.getSource();
    //     Point p = b.getLocationOnScreen();
    //     menu.show(c, 0, 0);
    //     menu.setLocation(p.x, p.y + b.getHeight());
    // }
}

