import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class _358Test {

    private boolean check(String given, String res, int k) {
        char[] a = given.toCharArray();
        char[] b = given.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        if (!String.valueOf(a).equals(String.valueOf(b))) return false;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int pre = -1;
            for (int i = 0; i < res.length(); i++)
                if (res.charAt(i) == ch) {
                    if (pre != -1 && i - pre < k) return false;
                    pre = i;
                }
        }
        return true;
    }

    @Test
    public void test() throws Exception {
        _358 sol = new _358();
        String str = "aabbcc";
        int k = 3;
        String actual = sol.rearrangeString(str, k);
        assertTrue(check(str, actual, k));
    }

    @Test
    public void test1() throws Exception {
        _358 sol = new _358();
        String str = "aaabc";
        int k = 3;
        String actual = sol.rearrangeString(str, k);
        assertEquals("", actual);
    }

    @Test
    public void test2() throws Exception {
        _358 sol = new _358();
        String str = "aaadbbcc";
        int k = 2;
        String actual = sol.rearrangeString(str, k);
        System.out.println(actual);
        assertTrue(check(str, actual, k));
    }

    @Test
    public void test3() throws Exception {
        _358 sol = new _358();
        String str = "aaa";
        int k = 0;
        String actual = sol.rearrangeString(str, k);
        assertTrue(check(str, actual, k));
    }

    @Test
    public void test4() throws Exception {
        _358 sol = new _358();
        String str = "abaa";
        int k = 0;
        String actual = sol.rearrangeString(str, k);
        assertTrue(check(str, actual, k));
    }
}

