import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Map;

import javax.swing.JPanel;

public class BrickPanel extends JPanel implements java.awt.event.KeyListener {
    private final Map<Integer, Point> brickMap;
    private final int GRID_SIZE = 40; // Size of each grid cell in pixels
    private int x;
    private int y;

    public BrickPanel(Map<Integer, Point> brickMap, int x, int y) {
        this.brickMap = brickMap;
        this.x = x;
        this.y = y;
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> x--;
            case KeyEvent.VK_RIGHT -> x++;
        }
        repaint(); // Repaint the panel to reflect the changes
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
