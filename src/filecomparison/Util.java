package filecomparison;

import java.io.File;
import java.io.IOException;

class Util {
    static boolean equal(String filename1, String filename2) throws IOException {
        return com.google.common.io.Files.equal(new File(filename1), new File(filename2));
    }
    static String[] fileList(File path, String regex) {
        return path.list(new DirFilter(regex));
    }
    
}
