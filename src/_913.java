import java.util.Arrays;

/**
 * LeetCode 913 - Cat and Mouse
 *
 * Game Theory
 * However, the underlying graph may contain directed cycles, resulting draws.
 * Also, the potential cycles also prevent us from solving the problem via DP.
 *
 * Instead of DP, this solution tries an iterative approach similar to Bellman-Ford. That is, we try to make as many
 * predictions as possible until we can no longer do so.
 */
public class _913 {

    int HOLE = 0;
    int MOUSE = 1;
    int CAT = 2;

    enum Result {
        UNKNOWN,
        MOUSE_WIN,
        CAT_WIN,
    }

    int[][] graph;
    Result[][][] prediction;


    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        this.graph = graph;

        prediction = new Result[2][n][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(prediction[i][j], Result.UNKNOWN);
            }
        }

        // An iterative approach similar to Bellman-Ford
        while (true) {
            int newPredictionCnt = 0;
            for (int t = 0; t < 2; t++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (prediction[t][i][j] == Result.UNKNOWN) {
                            Result attempt = predict(t, i, j);
                            if (attempt != Result.UNKNOWN) {
                                prediction[t][i][j] = attempt;
                                newPredictionCnt++;
                            }
                        }
                    }
                }
            }
            if (newPredictionCnt == 0) {
                break;
            }
        }

        return prediction[0][MOUSE][CAT].ordinal();
    }

    Result predict(int t, int mouse, int cat) {
        // Problem guarantees that it is impossible to have both mouse == 0 and cat == mouse.
        if (mouse == HOLE) {
            return Result.MOUSE_WIN;
        }
        if (mouse == cat) {
            return Result.CAT_WIN;
        }

        if (t % 2 == 0) {
            // Mouse move
            for (int i : graph[mouse]) {
                if (prediction[t ^ 1][i][cat] == Result.MOUSE_WIN) {
                    return Result.MOUSE_WIN;
                }
            }
            for (int i : graph[mouse]) {
                if (prediction[t ^ 1][i][cat] == Result.UNKNOWN) {
                    return Result.UNKNOWN;
                }
            }
            return Result.CAT_WIN;
        } else {
            // Cat move
            for (int i : graph[cat]) {
                if (i == HOLE) continue;
                if (prediction[t ^ 1][mouse][i] == Result.CAT_WIN) {
                    return Result.CAT_WIN;
                }
            }
            for (int i : graph[cat]) {
                if (i == HOLE) continue;
                if (prediction[t ^ 1][mouse][i] == Result.UNKNOWN) {
                    return Result.UNKNOWN;
                }
            }
            return Result.MOUSE_WIN;
        }
    }
}

