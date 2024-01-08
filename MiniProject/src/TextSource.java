import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

public class TextSource {
    private Vector<String> wordVector = new Vector<String>(30000);
    public TextSource(Component parent) {
        try {
            Scanner scanner = new Scanner(new FileReader("words.txt"));
            while(scanner.hasNext()) {
                String word = scanner.nextLine();
                wordVector.add(word);
            }
            scanner.close(); // 한 프로그램 안에서는 close 한번만.
            JOptionPane.showMessageDialog(parent, "단어 읽기 완료");
        }
        catch(FileNotFoundException e) {
            System.out.println("파일 없어요.");
            System.exit(0);
        }
    }

    public String next() {
        int n = wordVector.size();
        int index = (int)(Math.random() * n);
        return wordVector.get(index);
    }
}
