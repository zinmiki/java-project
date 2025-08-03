import java.awt.Point;
import java.util.Map;

import javax.swing.JPanel;

public class BrickPanel extends JPanel{
    private final Map<Integer, Point> brickMap;
    private final int GRID_SIZE = 40; // Size of each grid cell in pixels
    

    public BrickPanel(Map<Integer, Point> brickMap) {
        this.brickMap = brickMap;
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        for (Point point : brickMap.values()) {
            g.fillRect(point.x * GRID_SIZE, point.y * GRID_SIZE, GRID_SIZE, GRID_SIZE); // grid size of 40x40 pixels
        }
    }
}
