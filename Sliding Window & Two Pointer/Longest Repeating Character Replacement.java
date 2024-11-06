/* 424. Longest Repeating Character Replacement - https://leetcode.com/problems/longest-repeating-character-replacement
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length */

// Brutforce Approach TC - O(N^2), SC - O(26)
class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int maxlen = 0;
        for(int i=0;i<len;i++)
        {
            int maxf = 0;
            int[] hash = new int[26];
            for(int j=i;j<len;j++)
            {
                hash[s.charAt(j)-'A']++;
                maxf = Math.max(maxf, hash[s.charAt(j)-'A']);
                int changes = (j-i+1) - maxf;
                if(changes <= k) maxlen = Math.max(maxlen, (j-i+1));
                else break;
            }
        }
        return maxlen;
    }
}

// Optimal Approach TC - O(N), SC - O(26)
class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int maxlen = 0;
        int[] hash = new int[26];
        int maxf = 0, left = 0;
        for(int right=0;right<len;right++)
        {
            hash[s.charAt(right)-'A']++;
            maxf = Math.max(maxf, hash[s.charAt(right)-'A']);
            int changes = (right-left+1) - maxf;
            if(changes > k)
            {
                hash[s.charAt(left)-'A']--;
                left++;
            }
            maxlen = Math.max(maxlen, (right-left+1));
        }
        return maxlen;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int maxlen = 0;
        int[] hash = new int[26];
        int maxf = 0, left = 0;
        for(int right=0;right<len;right++)
        {
            hash[s.charAt(right)-'A']++;
            maxf = Math.max(maxf, hash[s.charAt(right)-'A']);
            while (right - left + 1 - maxf > k) {
                hash[s.charAt(left) - 'A']--;
                left++;
            }
            maxlen = Math.max(maxlen, (right-left+1));
        }
        return maxlen;
    }
}