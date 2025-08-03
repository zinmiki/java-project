import java.awt.Point;
import java.util.Map;

import javax.swing.JPanel;

public class BrickPanel extends JPanel{
    private final Map<Integer, Point> brickMap;
    private final int GRID_SIZE = 40; // Size of each grid cell in pixels
    private final int x;
    private final int y;

    public BrickPanel(Map<Integer, Point> brickMap, int x, int y) {
        this.brickMap = brickMap;
        this.x = x;
        this.y = y;
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        for (Point point : brickMap.values()) {
            g.fillRect((x + point.x) * GRID_SIZE, (y + point.y) * GRID_SIZE, GRID_SIZE, GRID_SIZE); // grid size of 40x40 pixels
        }
    }
}
