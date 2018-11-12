import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * LeetCode 937 - Reorder Log Files
 */
public class _937 {

    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLog = new ArrayList<>();
        List<String> digitLog = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.charAt(log.length() - 1))) {
                digitLog.add(log);
            } else {
                letterLog.add(log);
            }
        }

        Collections.sort(letterLog, Comparator.comparing(log -> {
            int idx = log.indexOf(' ');
            return log.substring(idx + 1) + " " + log.substring(0, idx);
        }));

        return Stream.concat(letterLog.stream(), digitLog.stream()).toArray(String[]::new);
    }
}

