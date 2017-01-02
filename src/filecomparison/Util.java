package filecomparison;

import java.io.File;
import java.io.IOException;

class Util {
    static boolean equal(String filename1, String filename2) throws IOException {
        return com.google.common.io.Files.equal(new File(filename1), new File(filename2));
    }
    static String[] getFileList(File path, String regex) {
        return path.list(new DirFilter(regex));
    }
    static File[] getFileList(String[] filenameList) {
        File[] fileList = new File[filenameList.length];
        for(int i = 0; i < fileList.length; i++) {
            fileList[i] = new File(filenameList[i]);
        }
        return fileList;
    }
}
