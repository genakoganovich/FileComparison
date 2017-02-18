package filecomparison;


import javax.swing.*;

class FileComparisonFrame extends JFrame
{
    FileComparisonFrame()
    {
        JPanel fileExplorerPanel = new FileExplorerPanel();
        fileExplorerPanel.setLayout(new BoxLayout(fileExplorerPanel, BoxLayout.LINE_AXIS));
        add(fileExplorerPanel);
        pack();
    }
}