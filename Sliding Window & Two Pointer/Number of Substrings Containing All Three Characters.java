/* Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1

Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters. */

// Brutforce Approach TC - O(N^2), SC - O(3)
class Solution {
    public int numberOfSubstrings(String s) {
        int len = s.length();
        int count=0;
        for(int i=0;i<len;i++)
        {
            Set<Character> set = new HashSet<>();
            for(int j=i;j<len;j++)
            {
                set.add(s.charAt(j));
                if(set.size() >=3) count++;
            }
        }
        return count;
    }
}

// Optimal Approach TC - O(N), SC - O(1)
class Solution {
    public int numberOfSubstrings(String s) {
        int len = s.length();
        int count=0, left = 0;
        int[] fre = new int[3];
        for(int right=0;right<len;right++)
        {
            fre[s.charAt(right)-'a']++;
            while(fre[0] > 0 && fre[1] > 0 && fre[2] > 0)
            {
                fre[s.charAt(left)-'a']--;
                left++;
                count+= s.length() - right;
            }
        }
        return count;
    }
}
