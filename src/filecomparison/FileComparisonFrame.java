package filecomparison;


import javax.swing.*;
import java.awt.event.ActionEvent;

class FileComparisonFrame extends JFrame
{
    FileComparisonFrame()
    {
        JPanel fileExplorerPanel = new FileExplorerPanel();
        fileExplorerPanel.setLayout(new BoxLayout(fileExplorerPanel, BoxLayout.LINE_AXIS));
        add(fileExplorerPanel);

        JMenu testMenu = new JMenu("Test");
        testMenu.add(new TestAction("Adaptive subtraction"));
        testMenu.add(new TestAction("Despike"));
        testMenu.add(new TestAction("LNA"));
        testMenu.add(new TestAction("gn3160"));
        testMenu.add(new TestAction("Radon MA"));
        testMenu.add(new TestAction("Radon TauP"));


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(testMenu);
        pack();
    }
    class TestAction extends AbstractAction
    {
        public TestAction(String name)
        {
            super(name);
        }

        public void actionPerformed(ActionEvent event)
        {
            System.out.println(getValue(Action.NAME) + " selected.");
        }
    }
}