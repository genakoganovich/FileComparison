package filecomparison;
import java.io.File;
import java.io.IOException;
import java.util.Map;

class FileComparison {
    /**
     * just to test com.google.common.io.Files.equal
     */
    void test() {
        String filename1 = "c:/Users/gennady/files_to_compare/01_eq/file1.txt";
        String filename2 = "c:/Users/gennady/files_to_compare/01_eq/file2.txt";
        try {
            System.out.println("" + Util.equal(filename1, filename2));
        } catch (IOException e) {
            System.out.println("File not exist");
        }
    }
    void test2() {
        String path = "c:/Users/gennady/files_to_compare/02_list/";
        String[] fileList = Util.getFileList(new File(path), ".*.txt");
        for(String s: fileList) {
            System.out.println(s);
        }
    }
    void test3() {
        String path = "c:/Users/gennady/files_to_compare/02_list/";
        File[] fileList = Util.getFileList(Util.getFileList(new File(path), ".*.txt"));
        for(File file: fileList) {
            System.out.println(file.getAbsolutePath());
        }
    }
    void test4() {
        String path = "c:/Users/gennady/files_to_compare/02_list/";
        File[] fileList = Util.getFileList(Util.getFileList(new File(path), ".*.txt"));
        PairDivider pairDivider = new PairDivider(new AdaptiveSubtractionStrategy());
        Map<File, File> result = pairDivider.divide(fileList);
        System.out.println(result);
    }
    void test5() {
        String path = "c:/Users/gennady/files_to_compare/02_list/";
        File[] fileList = Util.getFileList(Util.getFileList(new File(path), ".*.txt"));
        PairDivider pairDivider = new PairDivider(new LNAStrategy());
        Map<File, File> result = pairDivider.divide(fileList);
        System.out.println(result);
    }
}
