package filecomparison;


import javax.swing.*;
import java.io.File;

class FileComparisonFrame extends JFrame
{
    FileComparisonFrame()
    {
        add(new FileTree(new File(".")));
        pack();
    }
}