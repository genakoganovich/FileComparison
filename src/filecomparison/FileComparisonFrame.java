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
        testMenu.add(new TestAction("Adaptive subtraction", new AdaptiveSubtractionStrategy("Adaptive subtraction")));
        testMenu.add(new TestAction("Despike", new AdaptiveSubtractionStrategy("Despike")));
        testMenu.add(new TestAction("LNA", new LNAStrategy("LNA")));
        testMenu.add(new TestAction("gn3160", new GN3160Strategy("gn3160")));
        testMenu.add(new TestAction("Radon MA", new AdaptiveSubtractionStrategy("Radon MA")));
        testMenu.add(new TestAction("Radon TauP", new AdaptiveSubtractionStrategy("Radon TauP")));
        testMenu.add(new TestAction("All", new AdaptiveSubtractionStrategy("All")));


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