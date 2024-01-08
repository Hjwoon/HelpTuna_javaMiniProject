import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGround extends JPanel {
    private ScorePanel scorePanel = null;
    private JLabel label = new JLabel("여기");
    private JTextField textInput = new JTextField(20);
    private TextSource textSource = null;

    public GameGround(ScorePanel scorePanel) {
        this.scorePanel = scorePanel;
        setLayout(null);
        label.setSize(100, 20);
        label.setLocation(10, 10);
        add(label);

        textInput.setSize(300,20);
        textInput.setLocation(30, 400);
        add(textInput);

        // Enter키 입력 이벤트 처리
        textInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                e.getSource();
                JTextField tf = (JTextField)e.getSource();
                String text = tf.getText();

                if(text.equals(label.getText())) {
                    scorePanel.increase();
                    String word = textSource.next();
                    label.setText(word);
                    label.setLocation(10, 10); // 맞추면 단어 다시 올라감
                    tf.setText(""); // 맞추면 input 창 지워줌
                }
            }
        });

        textSource = new TextSource(this);
        MyThread th = new MyThread();
        th.start();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            while(true) {
                label.setLocation(label.getX(), label.getY() + 10);
                try {
                    sleep(1000); // ms 단위. 1초
                } catch (InterruptedException e) {
                    return; // 함수를 끝냄 => run 끝나면 스레드 종료
                }
            }
        }
    }
}
