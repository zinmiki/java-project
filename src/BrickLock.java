import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

import javax.swing.JPanel;

public class BrickLock extends JPanel {
    private boolean[][] lockedTiles = new boolean[10][15]; // 2D array to track locked tiles

    public BrickLock() {
        // Initialize the locked tiles to false
        for (int i = 0; i < lockedTiles.length; i++) {
            for (int j = 0; j < lockedTiles[i].length; j++) {
                lockedTiles[i][j] = false;
            }
        }
    }

    public void lockBrick(Map<Integer, Point> brickMap) {
        // Lock the tiles of the brick in the lockedTiles array
        for (Point point : brickMap.values()) {
            int x = point.x;
            int y = point.y;
            if (x >= 0 && x < lockedTiles.length && y >= 0 && y < lockedTiles[0].length) {
                lockedTiles[x][y] = true; // Mark the tile as locked
            }
        }
    }

    public boolean checkCollision(Map<Integer, Point> brickMap) {
        // Check for collision with floor and locked tiles
        for (Point point : brickMap.values()) {
            int x = point.x;
            int y = point.y;
            // Check collision with left/right walls, floor, and locked tiles
            if (x < 0 || x >= lockedTiles.length || y < 0 || y >= lockedTiles[0].length) {
                return true; // Collision with wall or floor detected
            }
            if (lockedTiles[x][y]) {
                return true; // Collision with locked tile detected
            }
        }
        return false; // No collision
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the locked tiles
        for (int i = 0; i < lockedTiles.length; i++) {
            for (int j = 0; j < lockedTiles[i].length; j++) {
                if (lockedTiles[i][j]) {
                    int x = i * BrickPanel.tileSize;
                    int y = j * BrickPanel.tileSize;
                    g.fillRect(x, y, BrickPanel.tileSize, BrickPanel.tileSize); // Draw each locked tile
                }
            }
        }
    }
}