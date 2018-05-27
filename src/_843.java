import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * LeetCode 843 - Guess the Word
 * <p>
 * MinMax Greedy
 */
public class _843 {

    public void findSecretWord(String[] wordList, Master master) {
        List<String> dict = Arrays.asList(wordList);
        for (int i = 0; i < 10 && dict.size() > 0; i++) {
            String bestGuess = "";
            int minOfMaxGroupSize = Integer.MAX_VALUE;

            for (String s : dict) {
                int[] cnt = new int[7];
                for (String ss : dict)
                    cnt[intersect(s, ss)]++;
                int maxGroupSize = IntStream.of(cnt).max().getAsInt();
                if (maxGroupSize < minOfMaxGroupSize) {
                    minOfMaxGroupSize = maxGroupSize;
                    bestGuess = s;
                }
            }

            int sizeByMaster = master.guess(bestGuess);
            if (sizeByMaster == 6)
                break;
            String finalBestGuess = bestGuess;
            dict = dict.stream().filter(s -> intersect(s, finalBestGuess) == sizeByMaster).collect(Collectors.toList());
        }
    }

    private int intersect(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) == s2.charAt(i))
                cnt++;
        return cnt;
    }
}

