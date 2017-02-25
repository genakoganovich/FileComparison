package filecomparison;

import java.io.*;

class DirFilter implements FileFilter {
    private String extension;
    DirFilter(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(File pathname) {
        if(pathname.getName().toLowerCase().endsWith(extension)) {
            return true;
        } else {
            return false;
        }
    }
}
