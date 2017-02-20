package filecomparison;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.io.File;

class FileExplorerPanel extends JPanel {
    private JTree tree;
    private static final String rootName = "c:\\";
    private DefaultMutableTreeNode rootNode;
    private DefaultTreeModel treeModel;

    FileExplorerPanel() {
        File rootFile = new File(rootName);
        rootNode = new DefaultMutableTreeNode(rootFile.getAbsolutePath());
        treeModel = new DefaultTreeModel(rootNode);

        addNodes(rootFile);

        tree = new JTree(treeModel);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(new NodeSelectionListener());
        tree.setRootVisible(false);
        JScrollPane treeView = new JScrollPane(tree);
        add(treeView);
        add(new JTextPane());
    }
    private void addNodes(File rootFile) {
        File[] fileList = rootFile.listFiles();
        for (File file: fileList) {
            DefaultMutableTreeNode node = new FileTreeNode(file);
            if(file.isDirectory()) {
                node.add(new DefaultMutableTreeNode("empty"));
            }
            rootNode.add(node);
        }
    }
    private class NodeSelectionListener implements TreeSelectionListener {

        @Override
        public void valueChanged(TreeSelectionEvent e) {
            FileTreeNode node = (FileTreeNode) tree.getLastSelectedPathComponent();
            if (node == null || node.isLeaf() && !node.isParent()) return;
            String name = node.getFile().getAbsolutePath();
            rootNode.removeAllChildren();

            File rootFile = new File(name);
            rootNode = new DefaultMutableTreeNode(rootFile.getAbsolutePath());
            treeModel.setRoot(rootNode);
            File parent = rootFile.getParentFile();
            if(parent != null && parent.exists()) {
                rootNode.add(new FileTreeNode(parent, true));
            }

            addNodes(rootFile);
            treeModel.reload();
        }
    }
}
