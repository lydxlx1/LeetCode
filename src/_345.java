/**
 * LeetCode 345 - Reverse Vowels of a String
 *
 * Two pointers technique
 */
public class _345 {
    boolean isVowel(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch = (char)(ch + 'a' - 'A');
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        for (int i=0, j=s.length()-1; i<s.length(); i++) {
            while(j >= 0 && !isVowel(ch[j])) j--;
            if (isVowel(ch[i]) && i < j) {
                char tmp = ch[i]; ch[i] = ch[j]; ch[j] = tmp;
                j--;
            }
        }
        return String.valueOf(ch);
    }
}