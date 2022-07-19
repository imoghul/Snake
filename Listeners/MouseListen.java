package Listeners;
import Features.Values;
import Graphics.Shape;
import Graphics.PIDController;
import Graphics.Button;
import Graphics.Slider;
import Graphics.Collision;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MouseListen implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        Values.mouse.setIsPressed(true);// Values.mousePressed = true;
        // Values.mouse.setIsClicked(true);
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        Values.mouse.setIsPressed(false);// Values.mousePressed = false;
        // Values.mouse.setisReleased(true);
        Values.mouse.clear();
    }

}
