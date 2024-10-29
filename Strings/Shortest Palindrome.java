/* You are given a string s. You can convert s to a 
palindrome
 by adding characters in front of it.

Return the shortest palindrome you can find by performing this transformation.

Example 1:

Input: s = "aacecaaa"
Output: "aaacecaaa"
Example 2:

Input: s = "abcd"
Output: "dcbabcd"
 
Constraints:

0 <= s.length <= 5 * 104
s consists of lowercase English letters only. */

// Brutforce Approach TC - O(N^2), SC - O(N)
class Solution {
    public String shortestPalindrome(String s) {
        for (int i = s.length(); i > 0; i--) {
            if (isPalindrome(s, 0, i)) {
                StringBuilder sb = new StringBuilder(s.substring(i));
                return sb.reverse().toString() + s;
            }
        }
        return s;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(--end)) return false;
        }
        return true;
    }
}

// Better Approach TC - O(N), SC - O(N)

class Solution { // Using KMP
    public String shortestPalindrome(String s) {
        String reversedS = new StringBuilder(s).reverse().toString();
        String modifiedString = s + "#" + reversedS;
        int[] prefixTable = kmpPrefixTable(modifiedString);
        int longestPalindromicPrefix = prefixTable[modifiedString.length() - 1];
        String suffix = s.substring(longestPalindromicPrefix);
        return new StringBuilder(suffix).reverse().toString() + s;
    }

    private int[] kmpPrefixTable(String s) {
        int n = s.length();
        int[] table = new int[n];
        int j = 0;

        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = table[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            table[i] = j;
        }
        return table;
    }
}


class Solution {
  public String shortestPalindrome(String s) {
    String t = new StringBuilder(s).reverse().toString();
    for (int i = 0; i < t.length(); i++) {
      if (s.startsWith(t.substring(i))) {
        return t.substring(0, i) + s;
      }
    }
    return t + s;
  }
}