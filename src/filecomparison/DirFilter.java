package filecomparison;

import java.util.regex.*;
import java.io.*;

class DirFilter implements FilenameFilter {
    private Pattern pattern;
    DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
