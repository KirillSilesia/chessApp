package game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mouse extends MouseAdapter{
    public int x,y;
    public boolean pressed;

    @Override
    public void mousePressed(MouseEvent e) {
        pressed = true;
        System.out.println("Mouse pressed at: " + e.getX() + ", " + e.getY()); // Debugging mouse press
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pressed = false;
        System.out.println("Mouse released at: " + e.getX() + ", " + e.getY()); // Debugging mouse press
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }
}
