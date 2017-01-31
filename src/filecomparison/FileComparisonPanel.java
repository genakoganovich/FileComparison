package filecomparison;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.io.File;

class FileComparisonPanel  extends JPanel {
    private JTree tree;
    private static final String rootName = "c:\\";
    private DefaultMutableTreeNode rootNode;
    private DefaultTreeModel treeModel;

    FileComparisonPanel() {
        File rootFile = new File(rootName);

        rootNode = new DefaultMutableTreeNode(rootFile.getAbsolutePath());
        treeModel = new DefaultTreeModel(rootNode);
        File[] fileList = rootFile.listFiles();
        for (File file: fileList) {
            DefaultMutableTreeNode node = new FileTreeNode(file);
            if(file.isDirectory()) {
                node.add(new DefaultMutableTreeNode("empty"));
            }
            rootNode.add(node);
        }
        tree = new JTree(treeModel);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(new NodeSelectionListener());
        JScrollPane treeView = new JScrollPane(tree);
        add(treeView);
    }

    private class NodeSelectionListener implements TreeSelectionListener {

        @Override
        public void valueChanged(TreeSelectionEvent e) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (node == null) return;
            if(node instanceof FileTreeNode) {
                System.out.println(((FileTreeNode) node).getFile().getAbsolutePath());

            }
        }
    }
}
