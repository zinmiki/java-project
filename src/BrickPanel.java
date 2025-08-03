import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.JPanel;

public class BrickPanel extends JPanel implements KeyListener {
    private final Map<Integer, Point> brickMap;
    private final int tileSize = 40; // Size of each tile in pixels

    private int x = 3;
    private int y = 0;

    public BrickPanel(Brick brick) {
        this.brickMap = brick.getBrickMap(0); // Default to variant 0

        setFocusable(true); // Make the panel focusable to receive key events
        addKeyListener(this);
    }

    @Override // Draw the bricks on the panel
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Point point : brickMap.values()) {
            int x = (this.x + point.x) * tileSize;
            int y = (this.y + point.y) * tileSize;
            g.fillRect(x, y, tileSize, tileSize); // Draw each tile of the brick
        }
    }

    // Key lissener methods to move the brick
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> this.x--;
            case KeyEvent.VK_RIGHT -> this.x++;
        }
        repaint(); // Repaint the panel to reflect changes
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}