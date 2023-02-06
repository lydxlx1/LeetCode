/**
 * LeetCode 2559 - Count Vowel Strings in Ranges
 *
 * Prefix Sum problem
 * Time complexity: O(N + Q)
 * Space complexity: O(N), excluding the space for the output.
 */ 
class Solution {
public:
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        const string vowel = "aeiou";
        auto is_vowel = [&](char ch) { return vowel.find(ch) != vowel.npos; };
        int n = words.size();
        vector<int> prefix_sum(n);
        
        for (int i=0; i<n; i++) {
            prefix_sum[i] = is_vowel(words[i][0]) && is_vowel(words[i].back()) ? 1 : 0;
            prefix_sum[i] += i - 1 >= 0 ? prefix_sum[i-1] : 0;
        }

        int q = queries.size();
        vector<int> ans(q);
        for (int i=0; i<q; i++) {
            int l = queries[i][0], r = queries[i][1];
            ans[i] = prefix_sum[r] - (l - 1 >= 0 ? prefix_sum[l - 1] : 0);
        }       
        return ans;
    }
};