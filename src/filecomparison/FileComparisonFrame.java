package filecomparison;


import javax.swing.*;
import java.awt.event.ActionEvent;

class FileComparisonFrame extends JFrame
{

    private FileExplorerPanel fileExplorerPanel;

    FileComparisonFrame()
    {
        fileExplorerPanel = new FileExplorerPanel();
        fileExplorerPanel.setLayout(new BoxLayout(fileExplorerPanel, BoxLayout.LINE_AXIS));
        add(fileExplorerPanel);

        JMenu testMenu = new JMenu("Test");
        testMenu.add(new TestAction("Adaptive subtraction", new AdaptiveSubtractionStrategy()));
        testMenu.add(new TestAction("Despike", new AdaptiveSubtractionStrategy()));
        testMenu.add(new TestAction("LNA", new LNAStrategy()));
        testMenu.add(new TestAction("gn3160", new GN3160Strategy()));
        testMenu.add(new TestAction("Radon MA", new AdaptiveSubtractionStrategy()));
        testMenu.add(new TestAction("Radon TauP", new AdaptiveSubtractionStrategy()));
        testMenu.add(new TestAction("All", new AdaptiveSubtractionStrategy()));


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(testMenu);
        pack();
    }
    class TestAction extends AbstractAction
    {
        PairDividerStrategy pairDividerStrategy;

        public TestAction(String name, PairDividerStrategy pairDividerStrategy)
        {
            super(name);
            this.pairDividerStrategy = pairDividerStrategy;
        }

        public void actionPerformed(ActionEvent event)
        {
            fileExplorerPanel.addText(pairDividerStrategy);
        }
    }
}