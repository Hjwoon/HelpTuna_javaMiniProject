import javax.swing.JFrame;

import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame() {
        setTitle("Help Tuna!");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel());

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        setVisible(true);
    }
}
