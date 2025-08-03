import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Map;
import javax.swing.Timer;

import javax.swing.JPanel;

public class BrickPanel extends JPanel implements java.awt.event.KeyListener {
    private final Map<Integer, Point> brickMap;
    private final int GRID_SIZE = 40; // Size of each grid cell in pixels
    private int x;
    private int y;
    private boolean moveable = true; // Flag to check if the brick can move

    private final Timer timer;

    public BrickPanel(Map<Integer, Point> brickMap, int x, int y) {
        this.brickMap = brickMap;
        this.x = x;
        this.y = y;
        setFocusable(true);
        addKeyListener(this);
        
        timer = new Timer(500, _ -> {
            this.y++;
            repaint(); // Repaint the panel to reflect the changes
            
            // Check if the brick has reached the bottom of the panel
            if (this.y + getBrickHeight() > 14) {
                this.y = 14 - getBrickHeight(); // Stop at the bottom
                moveable = false; // Stop moving the brick
            }
        });
        timer.start(); // Start the timer to move the brick down every 500 milliseconds
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (moveable) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT -> x--;
                case KeyEvent.VK_RIGHT -> x++;
                case KeyEvent.VK_DOWN -> y++;
            }
            repaint(); // Repaint the panel to reflect the changes
        }
    }

    public int getBrickHeight() {
        int maxY = 0;
        for (Point point : brickMap.values()) {
            if (point.y > maxY) {
                maxY = point.y;
            }
        }
        return maxY + 1; // Return the height of the brick
    }

    // Not used but required by KeyListener interface
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        for (Point point : brickMap.values()) {
            g.fillRect((x + point.x) * GRID_SIZE, (y + point.y) * GRID_SIZE, GRID_SIZE, GRID_SIZE); // grid size of 40x40 pixels
        }
    }
}
