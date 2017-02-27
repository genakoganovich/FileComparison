package filecomparison;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.io.File;
import java.io.IOException;
import java.util.Map;

class FileExplorerPanel extends JPanel {
    private JTree tree;
    //private static final String WINDOWS_ROOT_NAME = "\\\\192.168.22.220\\d$\\Data\\bug\\initial_test\\";
    //private static final String LINUX_ROOT_NAME = "c:\\run\\initial_test\\";
    private FileTreeNode rootNode;
    private DefaultTreeModel treeModel;
    private JTextPane jTextPane;

    FileExplorerPanel(String rootName) {

        File rootFile = new File(rootName);
        rootNode = new FileTreeNode(rootFile);
        treeModel = new DefaultTreeModel(rootNode);

        addNodes(rootFile);

        tree = new JTree(treeModel);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(new NodeSelectionListener());
        tree.setRootVisible(false);
        JScrollPane treeView = new JScrollPane(tree);
        add(treeView);
        jTextPane = new JTextPane();
        add(jTextPane);
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
    void setText(String text) {
        jTextPane.setText(text);
    }
    void addText(PairDividerStrategy pairDividerStrategy) {
        File[] listFile = rootNode.getFile().listFiles(new DirFilter(".sgy"));

        StringBuilder sb = new StringBuilder();
        sb.append(pairDividerStrategy.toString());
        sb.append("\n\n");
        Map<File, File> map = pairDividerStrategy.divide(listFile);
        for(Map.Entry<File, File> entry : map.entrySet()) {
            File key = entry.getKey();
            File value = entry.getValue();
            sb.append(key.getName());
            sb.append(" does ");
            try {
                if(!com.google.common.io.Files.equal(key, value)) {
                    sb.append("NOT ");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            sb.append("equal ");
            sb.append(value.getName());
            sb.append("\n");
        }

        jTextPane.setText(sb.toString());
    }
    void rebuildTree(String name) {
        rootNode.removeAllChildren();

        File rootFile = new File(name);
        rootNode = new FileTreeNode(rootFile);
        treeModel.setRoot(rootNode);
        File parent = rootFile.getParentFile();
        if(parent != null && parent.exists()) {
            rootNode.add(new FileTreeNode(parent, true));
        }

        addNodes(rootFile);
        treeModel.reload();

    }
    private class NodeSelectionListener implements TreeSelectionListener {

        @Override
        public void valueChanged(TreeSelectionEvent e) {
            FileTreeNode node = (FileTreeNode) tree.getLastSelectedPathComponent();
            if (node == null || node.isLeaf() && !node.isParent()) return;
            rebuildTree(node.getFile().getAbsolutePath());
            jTextPane.setText(rootNode.getFile().getAbsolutePath());
        }
    }
}
