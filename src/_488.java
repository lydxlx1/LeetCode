import java.util.*;


/**
 * LeetCode 488 - Zuma Game
 * <p>
 * BFS approach
 */
public class _488 {

    public int findMinStep(String board, String hand) {
        char[] handChars = hand.toCharArray();
        Arrays.sort(handChars);
        hand = String.valueOf(hand);
        return bfs(board, hand);
    }

    private int bfs(String board, String hand) {
        if (board.isEmpty()) return 0;
        if (hand.isEmpty()) return -1;


        int m = hand.length();
        Queue<List<String>> queue = new ArrayDeque<>();
        Set<List<String>> visited = new HashSet<>();
        queue.add(Arrays.asList(board, hand));
        visited.add(Arrays.asList(board, hand));
        while (!queue.isEmpty()) {
            board = queue.peek().get(0);
            hand = queue.poll().get(1);

            for (int i = 0, j; i < hand.length(); ) {
                char ch = hand.charAt(i);
                String newHand = hand.substring(0, i) + hand.substring(i + 1);

                // Insert ch to the left of the pos-th characters.
                // If pos == length, then insert ch at the end.
                for (int pos = 0; pos <= board.length(); pos++)
                    // A strong condition
                    // We require the inserted ball should have the same color with at least one of its neighbors.
                    if ((pos < board.length() && board.charAt(pos) == ch) || (pos - 1 >= 0 && board.charAt(pos - 1) == ch)) {
                        String newBoard = shrink(board.substring(0, pos) + ch + board.substring(pos));
                        if (newBoard.isEmpty()) return m - newHand.length();

                        List<String> list = Arrays.asList(newBoard, newHand);
                        if (!visited.contains(list)) {
                            queue.add(list);
                            visited.add(list);
                        }
                    }

                // Skip those balls with the same color.
                for (j = i + 1; j < hand.length() && hand.charAt(j) == ch; j++) ;
                i = j;
            }
        }
        return -1;
    }

    private String shrink(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        boolean exit = false;
        while (!exit) {
            exit = true;
            int newLen = 0;
            for (int i = 0, j; i < len; ) {
                for (j = i + 1; j < len && chars[j] == chars[i]; j++) ;
                if (j - i >= 3) {
                    // Skip these balls
                    exit = false;
                } else {
                    for (j = i; j < len && chars[j] == chars[i]; j++)
                        chars[newLen++] = chars[j];
                }
                i = j;
            }
            len = newLen;
        }
        return String.valueOf(chars, 0, len);
    }
}

