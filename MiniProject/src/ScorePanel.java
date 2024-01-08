import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    private int score = 0;
    private JLabel scoreLabel = new JLabel(Integer.toString(score));
    public ScorePanel() {
        setBackground(Color.YELLOW);
        add(new JLabel("점수"));
        add(scoreLabel);
    }

    public void increase() {
        score += 10;
        scoreLabel.setText(Integer.toString(score));
    }

    public void decrease() {
        score += 10;
        if(score < 0)
            score = 0;
        scoreLabel.setText(Integer.toString(score));
    }
}
