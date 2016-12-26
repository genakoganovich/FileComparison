package filecomparison;

import java.io.File;
import java.io.IOException;

class FileComparison {
    /**
     * just to test com.google.common.io.Files.equal
     */
    void test() {
        String filename1 = "c:/Users/Gena/files_to_compare/HelloWorld.java";
        String filename2 = "c:/Users/Gena/files_to_compare/HelloWorld - Copy.java";
        try {
            System.out.println("" + Util.equal(filename1, filename2));
        } catch (IOException e) {
            System.out.println("File not exist");
        }
    }
}
