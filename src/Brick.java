import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Brick {
    private final Map<Integer, Map<Integer, Point>> bricksMap = new HashMap<>();

    public Brick() {
        initializeBricks();
    }

    private void initializeBricks() {
        // Variant 0:
        Map<Integer, Point> variant0 = new HashMap<>();
        variant0.put(0, new Point(0, 0));
        variant0.put(1, new Point(1, 0));
        variant0.put(2, new Point(2, 0));
        variant0.put(3, new Point(1, 1));
        bricksMap.put(0, variant0);
        // Variant 1:
        Map<Integer, Point> variant1 = new HashMap<>();
        variant1.put(0, new Point(0, 0));
        variant1.put(1, new Point(1, 0));
        variant1.put(2, new Point(2, 0));
        variant1.put(3, new Point(2, 1));
        bricksMap.put(1, variant1);
        // Variant 2:
        Map<Integer, Point> variant2 = new HashMap<>();
        variant2.put(0, new Point(0, 1));
        variant2.put(1, new Point(1, 1));
        variant2.put(2, new Point(1, 0));
        variant2.put(3, new Point(2, 0));
        bricksMap.put(2, variant2);
        // Variant 3:
        Map<Integer, Point> variant3 = new HashMap<>();
        variant3.put(0, new Point(0, 0));
        variant3.put(1, new Point(1, 0));
        variant3.put(2, new Point(1, 1));
        variant3.put(3, new Point(2, 1));
        bricksMap.put(3, variant3);
        // Variant 4:
        Map<Integer, Point> variant4 = new HashMap<>();
        variant4.put(0, new Point(0, 0));
        variant4.put(1, new Point(0, 1));
        variant4.put(2, new Point(1, 0));
        variant4.put(3, new Point(2, 0));
        bricksMap.put(4, variant4);
    }

    public Map<Integer, Point> getBrickMap(int variant) {
        return bricksMap.get(variant);
    }
}
