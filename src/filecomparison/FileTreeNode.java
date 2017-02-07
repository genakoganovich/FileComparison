package filecomparison;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;


class FileTreeNode extends DefaultMutableTreeNode {
    private File file;
    private boolean parent = false;

    FileTreeNode(File file) {
        super(file.getName());
        this.file = file;
    }
    FileTreeNode(File file, boolean parent) {
        super("...");
        this.file = file;
        this.parent = parent;
    }
    File getFile() {return file;}
    boolean isParent() {return parent;}
}
