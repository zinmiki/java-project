import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.Timer;

public class BrickPanel extends JPanel implements KeyListener {
    private final Map<Integer, Point> brickMap;
    public static int tileSize = 40; // Size of each tile in pixels

    private int x = 3;
    private int y = 0;

    BrickLock brickLock = new BrickLock(); // Create an instance of BrickLock to manage locked tiles

    private final Timer timer; // Timer for moving the brick down

    public BrickPanel(Brick brick) {
        this.brickMap = brick.getBrickMap(0); // Default to variant 0

        setFocusable(true); // Make the panel focusable to receive key events
        addKeyListener(this);

        timer = new Timer(500, _ -> {
            this.y++;
            repaint(); // Repaint the panel to reflect the changes

            if (brickLock.checkCollision(brickMap)) {
                System.out.println("Collision detected! Locking the brick.");
                brickLock.lockBrick(brickMap); // Lock the brick in place
                this.y--; // Move the brick back up to avoid collision
            }
        });
        timer.start(); // Start the timer to move the brick down
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

    public Map<Integer, Point> getBrickMap() {
        return brickMap;
    }
}