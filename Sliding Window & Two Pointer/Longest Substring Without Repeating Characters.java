/* 3. Longest Substring Without Repeating Characters - https://leetcode.com/problems/longest-substring-without-repeating-characters
Given a string s, find the length of the longest 
substring
 without repeating characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces. */

// Brutforce Approach TC (worst case) - O(N^2), SC - O(N)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        String str = "";
        int maxlen = 0;
        for(int i=0;i<s.length();i++)
        {
            if(str.contains(Character.toString(s.charAt(i))))
            {
                str = str.substring(str.indexOf(s.charAt(i)) +1) + s.charAt(i);
                continue;
            }
            str = str + s.charAt(i);
            maxlen = Math.max(maxlen, str.length());
        }
        return maxlen;
    }
}

// using StringBuilder TC (worst case) - O(N^2), SC - O(N)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder str = new StringBuilder();
        int maxlen = 0;
        for(int i=0;i<s.length();i++)
        {
            int index = str.indexOf(Character.toString(s.charAt(i)));
            if(index != -1)
            {
                str.delete(0,index +1).append(s.charAt(i));
                continue;
            }
            str = str.append(s.charAt(i));
            maxlen = Math.max(maxlen, str.length());
        }
        return maxlen;
    }
}

// Optimal Approach - 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder str = new StringBuilder();
        int maxlen = 0, left = 0;
        Set<Character> set = new HashSet<>();
        for(int right=0;right<s.length();right++)
        {
            if(set.contains(s.charAt(right)))
            {
                while(left < right && set.contains(s.charAt(right)))
                {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(s.charAt(right));
            maxlen = Math.max(maxlen, right - left +1);
        }
        return maxlen;
    }
}

// Optimising further 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int right = 0, maxlen = 0, left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(right < len)
        {
            if(map.containsKey(s.charAt(right))) left = Math.max(left, map.get(s.charAt(right))+1);
            map.put(s.charAt(right), right);
            maxlen = Math.max(maxlen, right - left + 1);
            right++;
        }
        return maxlen;
    }
}

