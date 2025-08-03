import java.awt.EventQueue;
import java.awt.Point;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(() -> {
            Frame frame = new Frame();
            frame.setVisible(true);

            Brick brick = new Brick();

            Map<Integer, Point> brickmap = brick.getBrickMap(0); // Example to get a brick variant

            frame.add(new BrickPanel(brickmap)); // Replace null with actual brickMap when available
        });
    }
}
