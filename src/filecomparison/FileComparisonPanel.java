package filecomparison;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

class FileComparisonPanel  extends JPanel {
    private JTree tree;

    FileComparisonPanel() {
        DefaultMutableTreeNode top =
                new DefaultMutableTreeNode("The Java Series");
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode book = null;

        category = new DefaultMutableTreeNode("Books for Java Programmers");
        top.add(category);
        book = new DefaultMutableTreeNode("The Java Tutorial: A Short Course on the Basics");
        category.add(book);
        tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);
        JScrollPane treeView = new JScrollPane(tree);
        add(treeView);
    }

}
