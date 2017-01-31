package filecomparison;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;


public class FileTreeNode extends DefaultMutableTreeNode {
    private File file;

    public FileTreeNode(File file) {
        super(file.getName());
        this.file = file;
    }
    File getFile() {return file;}
}
