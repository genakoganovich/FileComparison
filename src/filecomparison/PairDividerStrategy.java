package filecomparison;


import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class PairDividerStrategy {
    Map<File, File> divide(File[] fileList) {
        return null;
    }
}
class AdaptiveSubtractionStrategy extends PairDividerStrategy {
    Map<File, File> divide(File[] fileList) {
        Map<File, File> result = new LinkedHashMap<>();
        for (int i = 0; i < fileList.length; i += 2) {
            result.put(fileList[i], fileList[i + 1]);
        }
        return result;
    }
}
class GN3160Strategy extends PairDividerStrategy {
    Map<File, File> divide(File[] fileList) {
        Map<File, File> result = new LinkedHashMap<>();
        for (int i = 0; i < fileList.length - 1; i++) {
            result.put(fileList[i], fileList[i + 1]);
        }
        return result;
    }
}
class LNAStrategy extends PairDividerStrategy {
    Map<File, File> divide(File[] fileList) {
        Map<File, File> result = new LinkedHashMap<>();
        PairDividerStrategy strategy = new GN3160Strategy();
        for (int i = 0; i < fileList.length; i += 4) {
            result.putAll(strategy.divide(Arrays.copyOfRange(fileList, i, i + 4)));
        }
        return result;
    }
}
