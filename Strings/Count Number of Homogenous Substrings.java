/* 1759. Count Number of Homogenous Substrings - https://leetcode.com/problems/count-number-of-homogenous-substrings/
Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 109 + 7.

A string is homogenous if all the characters of the string are the same.

A substring is a contiguous sequence of characters within a string.

Example 1:

Input: s = "abbcccaa"
Output: 13
Explanation: The homogenous substrings are listed as below:
"a"   appears 3 times.
"aa"  appears 1 time.
"b"   appears 2 times.
"bb"  appears 1 time.
"c"   appears 3 times.
"cc"  appears 2 times.
"ccc" appears 1 time.
3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.
Example 2:

Input: s = "xy"
Output: 2
Explanation: The homogenous substrings are "x" and "y".
Example 3:

Input: s = "zzzzz"
Output: 15

Constraints:

1 <= s.length <= 105
s consists of lowercase letters. */

// Brutforce Approach - TC - O(N^3), SC - O(1)

class Solution {
    public int countHomogenous(String s) 
    {
        int len = s.length();
        int count = 0;
        final int MOD = 1_000_000_007;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String sub = s.substring(i, j + 1);
                if (isHomogenous(sub)) {
                    count = (count + 1) % MOD;
                }
            }
        }
        return count;
    }

    private boolean isHomogenous(String sub) {
        char firstChar = sub.charAt(0);
        for (char c : sub.toCharArray()) {
            if (c != firstChar) return false;
        }
        return true;
    }
}

// Better Approach TC - O(1), SC - O(N)
class Solution {
    private static final int MOD = 1_000_000_007;
    public int countHomogenous(String s) {
        int len = s.length();
        int right = 0;
        int left = 0, ans = 0;
        for(right = 0; right<len-1; right++)
        {
            if(s.charAt(right) != s.charAt(right+1))
            {
                int size = right - left + 1;
                ans = (ans + getcount(size)) % MOD;
                left = right+1;
            }
        }
        int size = right - left + 1;
        ans = (ans + getcount(size)) % MOD;
        return ans;  
    }

    private int getcount(int n)
    {
        int[] count = new int[n];
        count[0] = 1;
        for(int i=1;i<n;i++)
        {
            count[i] = (count[i-1]+i+1) % MOD;
        }
        return count[n-1];
    }
}

// Optimal Approach TC - O(N), SC - O(1)
class Solution {
    public int countHomogenous(String s) 
    {
        int len = s.length();
        int count = 1;
        long total = 0;
        final int MOD = 1_000_000_007;
        for (int i = 1; i <= len; i++) {
            if(i<len && s.charAt(i) == s.charAt(i-1))
            {
                count++;
            }
            else
            {
                total = (total + (long) count*(count+1)/2) % MOD;
                count = 1;
            }
        }
        return (int)total;
    }
}