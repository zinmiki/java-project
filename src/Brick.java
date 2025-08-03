import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Brick {
    private final Map<Integer, Map<Integer, Point>> bricksMap = new HashMap<>();

    public Brick() {
        initializeBricks();
    }

    private void initializeBricks() {
        // Variante 0:
        Map<Integer, Point> variant0 = new HashMap<>();
        variant0.put(0, new Point(0, 0));
        variant0.put(1, new Point(1, 0));
        variant0.put(2, new Point(2, 0));
        variant0.put(3, new Point(1, 1));
        bricksMap.put(0, variant0);
    }
}
