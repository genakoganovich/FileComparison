package filecomparison;


import javax.swing.*;

class FileComparisonFrame extends JFrame
{
    FileComparisonFrame()
    {
        add(new FileExplorerPanel());
        pack();
    }
}