package filecomparison;

import javax.swing.*;
import java.awt.*;

public class FileComparisonTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            FileComparisonFrame frame = new FileComparisonFrame();
            frame.setTitle("File comparison");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
