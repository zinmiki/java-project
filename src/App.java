import java.awt.EventQueue;

public class App {
    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(() -> {
            Frame frame = new Frame();
            frame.setVisible(true);
        });
    }
}
