package filecomparison;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

class FileComparisonPanel  extends JPanel {
    private JTree tree;

    FileComparisonPanel() {
        File root = new File("c:\\");

        DefaultMutableTreeNode top = new DefaultMutableTreeNode(root.getAbsolutePath());
        String[] fileNameList = root.list();
        for (String filename: fileNameList) {
            File file = new File(filename);
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(filename);
            System.out.println(file.getName());
            if(file.exists()) {
                System.out.println(file.getName() + " exists");
            } else {
                System.out.println(file.getAbsolutePath() + " not exist");
            }

            if(file.isDirectory()) {
                System.out.println(file.getName() + " is directory");
                node.add(new DefaultMutableTreeNode("empty"));
            }
            top.add(node);
        }
        tree = new JTree(top);
        JScrollPane treeView = new JScrollPane(tree);
        add(treeView);
    }

}
