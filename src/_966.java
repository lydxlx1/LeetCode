import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * LeetCode 966 - Vowel Spellchecker
 *
 * Mapper
 */
public class _966 {

    class Checker {
        Map<String, String> data = new HashMap<>();
        Function<String, String> mapper;

        Checker(String[] words, Function<String, String> mapper) {
            this.mapper = mapper;
            for (String word : words) {
                data.putIfAbsent(mapper.apply(word), word);
            }
        }

        String query(String query) {
            return data.get(mapper.apply(query));
        }
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Checker c1 = new Checker(wordlist, s -> s);
        Checker c2 = new Checker(wordlist, s -> s.toLowerCase());
        Checker c3 = new Checker(wordlist, s -> s.toLowerCase().replaceAll("[aeiou]", "?"));
        String[] res = new String[queries.length];
        for (int i = 0; i < res.length; i++) {
            String q = queries[i];
            res[i] = Stream.of(c1.query(q), c2.query(q), c3.query(q)).filter(s -> s != null).findFirst().orElse("");
        }
        return res;
    }
}

