"""
LeetCode 443 - String Compression

This problem is indeed broken.
For instance, how to expand the compressed string "c22"?
The decryption is not unique...
"""


class Solution:
    def compress(self, chars):
        """
        :type chars: List[str]
        :rtype: int
        """
        size = 0
        i = 0
        while i < len(chars):
            j = next(j for j in range(i, len(chars) + 1) if j >= len(chars) or chars[i] != chars[j])
            cnt = j - i
            s = chars[i] if cnt == 1 else '{ch}{cnt}'.format(ch=chars[i], cnt=cnt)
            chars[size:size + len(s)] = s
            size += len(s)
            i = j
        return size
