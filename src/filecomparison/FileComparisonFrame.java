package filecomparison;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

class FileComparisonFrame extends JFrame
{

    private FileExplorerPanel fileExplorerPanel;
    private static final String WINDOWS_ROOT_NAME = "\\\\192.168.22.220\\d$\\Data\\bug\\initial_test\\";
    //private static final String LINUX_ROOT_NAME = "c:\\run\\initial_test\\";
    private static final String LINUX_ROOT_NAME = "/home/gena/initial_test";
    private static final String WINDOWS = "Windows";
    private static final String LINUX = "Linux";
    private Map<String, String > operatingSystemRootNames;

    FileComparisonFrame()
    {
        fileExplorerPanel = new FileExplorerPanel(LINUX_ROOT_NAME);
        fileExplorerPanel.setLayout(new BoxLayout(fileExplorerPanel, BoxLayout.LINE_AXIS));
        add(fileExplorerPanel);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu testMenu = new JMenu("Test");
        testMenu.add(new TestAction("Adaptive subtraction", new AdaptiveSubtractionStrategy("Adaptive subtraction")));
        testMenu.add(new TestAction("Despike", new AdaptiveSubtractionStrategy("Despike")));
        testMenu.add(new TestAction("LNA", new LNAStrategy("LNA")));
        testMenu.add(new TestAction("gn3160", new GN3160Strategy("gn3160")));
        testMenu.add(new TestAction("Radon MA", new AdaptiveSubtractionStrategy("Radon MA")));
        testMenu.add(new TestAction("Radon TauP", new AdaptiveSubtractionStrategy("Radon TauP")));
        testMenu.add(new TestAction("All", new AdaptiveSubtractionStrategy("All")));

        operatingSystemRootNames = new HashMap<>();
        operatingSystemRootNames.put(WINDOWS, WINDOWS_ROOT_NAME);
        operatingSystemRootNames.put(LINUX, LINUX_ROOT_NAME);
        JMenu operatingSystemMenu = new JMenu("Operating System");
        operatingSystemMenu.add(new OperatingSystemSAction(WINDOWS));
        operatingSystemMenu.add(new OperatingSystemSAction(LINUX));
        menuBar.add(testMenu);
        menuBar.add(operatingSystemMenu);
        pack();
    }
    class TestAction extends AbstractAction
    {
        private PairDividerStrategy pairDividerStrategy;

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
    class OperatingSystemSAction extends AbstractAction {
        OperatingSystemSAction(String name) {
            super(name);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            fileExplorerPanel.setText((String )getValue(Action.NAME));
            fileExplorerPanel.rebuildTree(operatingSystemRootNames.get(getValue(Action.NAME)));
        }
    }
}