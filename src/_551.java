/**
 * LeetCode 551 - Student Attendance Record I
 *
 * 1-Liner
 */
public class _551 {
    public boolean checkRecord(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");
    }
}