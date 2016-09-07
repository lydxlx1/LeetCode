// LeetCode 151 - Reverse Words in a String
// In-place solution

void reverse(char *s, int i, int j) {
    for (; i < j; i++, j--) {
        char tmp = s[i]; s[i] = s[j]; s[j] = tmp;
    }
}

void reverseWords(char *s) {
    int l = 0, r = strlen(s), i, j, k, len = 0;

    // Step 1: trim(s)
    while(l < r && s[l] == ' ') l++;
    while(l < r && s[r - 1] == ' ') r--;
    for (i = l; i < r; i++) s[i - l] = s[i];
    s[i - l] = '\0';


    // Step 2: reverse each word and reduce multiple inter-spaces into one
    for (i = 0; s[i]; ) {
        for (j = i; s[j] && s[j] != ' '; j++);
        reverse(s, i, j - 1);
        for (k = i; k < j; k++) s[len++] = s[k];

        if (s[j] == ' ') {
            s[len++] = ' '; // only use the first space
            for (; s[j] == ' '; j++); // skip the remaining spaces
        }
        i = j;
    }
    s[len] = '\0';

    // Step 3: reverse the entire string
    reverse(s, 0, len - 1);
}
