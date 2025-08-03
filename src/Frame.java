import javax.swing.JFrame;

public class Frame extends JFrame {
    public Frame() {
        setSize(400, 600);
        setLocation(1920, 100);
        setTitle("Tetris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
}
