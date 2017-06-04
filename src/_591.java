/**
 * LeetCode 591 - Tag Validator
 * <p>
 * Recursive solution
 */
public class _591 {
    private int ptr;
    private String s;

    public boolean isValid(String code) {
        this.s = code;
        ptr = 0;
        return tag() && ptr == code.length();
    }

    private boolean tag() {
        if (s.startsWith("<", ptr)) {
            ptr++;
        } else {
            return false;
        }

        String tagName = nextUpperString(s, ptr);
        if (tagName.length() < 1 || tagName.length() > 9)
            return false;
        if (s.startsWith(">", ptr + tagName.length())) {
            ptr += tagName.length() + 1; // including '>'
        } else {
            return false;
        }

        if (!content())
            return false;

        String closingTag = "</" + tagName + ">";
        if (s.startsWith(closingTag, ptr)) {
            ptr += closingTag.length();
            return true;
        } else {
            return false;
        }
    }

    private String nextUpperString(String s, int i) {
        StringBuilder builder = new StringBuilder();
        for (; i < s.length() && Character.isUpperCase(s.charAt(i)); i++)
            builder.append(s.charAt(i));
        return builder.toString();
    }

    private boolean content() {
        ptr = s.indexOf("<", ptr);
        while (ptr != -1) {
            final String cdataPrefix = "<![CDATA[";
            final String cdataSuffix = "]]>";
            final String closingPrefix = "</";

            if (s.startsWith(closingPrefix, ptr))
                return true;
            else if (s.startsWith(cdataPrefix, ptr)) {
                int index = s.indexOf(cdataSuffix, ptr + cdataPrefix.length());
                if (index == -1)
                    return false;
                else
                    ptr = index + cdataSuffix.length();
            } else {
                // must be another open tag
                if (!tag())
                    return false;
            }

            ptr = s.indexOf("<", ptr);
        }
        return false; // must end with a closing tag signal
    }

    public static void main(String[] args) {
        _591 sol = new _591();
        System.out.println(sol.isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
        System.out.println(sol.isValid("<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"));
        System.out.println(sol.isValid("<A>  <B> </A>   </B>"));
        System.out.println(sol.isValid("<DIV>  div tag is not closed  <DIV>"));
        System.out.println(sol.isValid("<DIV>  unmatched <  </DIV>"));
        System.out.println(sol.isValid("<DIV> closed tags with invalid tag name  <b>123</b> </DIV>"));
        System.out.println(sol.isValid("<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>"));
        System.out.println(sol.isValid("<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>"));
        System.out.println(sol.isValid("<A>Parallel tags on the outermost level</A><B>shall not pass.</B>"));
        System.out.println(sol.isValid("<![CDATA[  cdata must be contained in some tags ]]>"));
        System.out.println(sol.isValid("<></>"));
        System.out.println(sol.isValid("<AAAAAAAAAA></AAAAAAAAAA>"));
    }
}