package filecomparison;


import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class PairDividerStrategy {
    private String stategyName;
    PairDividerStrategy(String stategyName) {
        this.stategyName = stategyName;
    }
    Map<File, File> divide(File[] fileList) {
        return null;
    }
    @Override
    public String toString() {return stategyName;}
}

class AdaptiveSubtractionStrategy extends PairDividerStrategy {
    AdaptiveSubtractionStrategy(String stategyName) {
        super(stategyName);
    }
    Map<File, File> divide(File[] fileList) {
        Map<File, File> result = new LinkedHashMap<>();
        for (int i = 0; i < fileList.length; i += 2) {
            result.put(fileList[i], fileList[i + 1]);
        }
        return result;
    }
}
class GN3160Strategy extends PairDividerStrategy {
    GN3160Strategy(String stategyName) {
        super(stategyName);
    }
    Map<File, File> divide(File[] fileList) {
        Map<File, File> result = new LinkedHashMap<>();
        for (int i = 0; i < fileList.length - 1; i++) {
            result.put(fileList[i], fileList[i + 1]);
        }
        return result;
    }
}
class LNAStrategy extends PairDividerStrategy {
    LNAStrategy(String stategyName) {
        super(stategyName);
    }
    Map<File, File> divide(File[] fileList) {
        Map<File, File> result = new LinkedHashMap<>();
        PairDividerStrategy strategy = new GN3160Strategy("gn3160");
        for (int i = 0; i < fileList.length; i += 4) {
            result.putAll(strategy.divide(Arrays.copyOfRange(fileList, i, i + 4)));
        }
        return result;
    }
}
