import java.util.List;
import java.util.Stack;

/**
 * LeetCode 636 - Exclusive Time of Functions
 * <p>
 * Using a stack
 */
public class _636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        class Data {
            int id;
            int startTime;
            int timeByOtherProc;

            public Data(int id, int startTime, int timeByOtherProc) {
                this.id = id;
                this.startTime = startTime;
                this.timeByOtherProc = timeByOtherProc;
            }
        }

        Stack<Data> s = new Stack<>();
        for (String log : logs) {
            String[] tokens = log.split(":");
            int id = Integer.parseInt(tokens[0]);
            int t = Integer.parseInt(tokens[2]);
            if (tokens[1].equals("start")) {
                s.push(new Data(id, t, 0));
            } else {
                Data data = s.pop();
                if (data.id != id)
                    throw new RuntimeException("id does not match...");

                int acc = t - data.startTime + 1 - data.timeByOtherProc;
                res[id] += acc;
                if (!s.isEmpty())
                    s.peek().timeByOtherProc += acc + data.timeByOtherProc;
            }
        }
        return res;
    }
}
