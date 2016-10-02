import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _407Test {

    @Test
    public void test() throws Exception {
        _407 sol = new _407();
        int[][] map = {
                {1, 4, 3, 1, 3, 2,},
                {3, 2, 1, 3, 2, 4,},
                {2, 3, 3, 2, 3, 1,},
        };
        int actual = sol.trapRainWater(map);
        assertEquals(4, actual);


        map = new int[][]{
                {1, 2},
                {2, 1},
        };
        actual = sol.trapRainWater(map);
        assertEquals(0, actual);
    }
}


