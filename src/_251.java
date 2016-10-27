import java.util.Iterator;
import java.util.List;

/**
 * LeetCode 251 - Flatten 2D Vector
 * <p>
 * Pay attention to the following case:
 * [
 * [1, 2],
 * [],
 * [3, 4],
 * ]
 */
public class _251 implements Iterator<Integer> {

    Iterator<List<Integer>> outerIterator;
    Iterator<Integer> innerIterator;

    public _251(List<List<Integer>> vec2d) {
        outerIterator = vec2d.iterator();
    }

    @Override
    public Integer next() {
        if (!hasNext()) throw new RuntimeException("No more element remains...");
        return innerIterator.next();
    }

    @Override
    public boolean hasNext() {
        if (innerIterator != null && innerIterator.hasNext()) return true;
        if (!outerIterator.hasNext()) return false;
        innerIterator = outerIterator.next().iterator();
        return hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */