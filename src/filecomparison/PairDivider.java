package filecomparison;
import java.io.File;
import java.util.Map;

class PairDivider {
    private PairDividerStrategy strategy;

    PairDivider(PairDividerStrategy strategy) {
        this.strategy = strategy;
    }
    Map<File, File> divide(File[] fileList) {
        return strategy.divide(fileList);
    }
}
