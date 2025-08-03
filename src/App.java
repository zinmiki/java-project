import java.awt.EventQueue;

public class App {
    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(() -> {
            Frame frame = new Frame();
            frame.setVisible(true);

            Brick brick = new Brick();
            frame.add(new BrickPanel(brick)); // Add the BrickPanel to the Frame
        });
    }
}
