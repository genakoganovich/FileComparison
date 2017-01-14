package filecomparison;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

class FileComparisonPanel  extends JPanel {
    private JTree tree;

    FileComparisonPanel() {
        File root = new File("c:\\");

        DefaultMutableTreeNode top = new DefaultMutableTreeNode(root.getAbsolutePath());
        File[] fileList = root.listFiles();
        for (File file: fileList) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(file.getName());
            if(file.isDirectory()) {
                node.add(new DefaultMutableTreeNode("empty"));
            }
            top.add(node);
        }
        tree = new JTree(top);
        JScrollPane treeView = new JScrollPane(tree);
        add(treeView);
    }

}
