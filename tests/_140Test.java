import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class _140Test {

    @org.junit.Test
    public void test() {
        Set<String> set = new HashSet<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));

        Set<String> ans = new HashSet<>((new _140()).wordBreak("catsanddog", set));
        Set<String> want = new HashSet<>(Arrays.asList("cats and dog", "cat sand dog"));
        assertEquals(ans, want);
    }

}