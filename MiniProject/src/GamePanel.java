import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

class GamePanel extends JPanel {
    private ScorePanel scorePanel = new ScorePanel();
    private ImageIcon backgroundImage = new ImageIcon("bg.jpg"); // 배경 이미지를 저장할 변수
    private Image img = backgroundImage.getImage();
    public GamePanel() {
        setBackground(Color.YELLOW);
        setLayout(new BorderLayout());
        splitPanel();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 배경 이미지 그리기
        if (backgroundImage != null) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        }
    }

    private void splitPanel() {
        JSplitPane hPane = new JSplitPane();
        hPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        hPane.setDividerLocation(ABORT);
        hPane.setDividerLocation(500);
        // 크기 고정 코드 추가
        add(hPane);

        JSplitPane vPane = new JSplitPane();
        vPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        vPane.setDividerLocation(300);
        vPane.setTopComponent(scorePanel);
        vPane.setBottomComponent(new EditPanel());

        hPane.setRightComponent(vPane);
        hPane.setLeftComponent(new GameGround(scorePanel));

    }
}