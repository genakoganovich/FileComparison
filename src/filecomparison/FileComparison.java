package filecomparison;
import java.io.File;
import java.io.IOException;
import java.util.Map;

class FileComparison {
    public static void main(String[] args) {
        File file = new File("c://");
        System.out.println(file.getAbsolutePath() + " " + file.exists());
        File[] fileList = file.listFiles();
        System.out.println(fileList[0].getAbsolutePath() + " " + fileList[0].exists());
    }
}
