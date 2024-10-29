/* 242. Valid Anagram - leetcode.com/problems/valid-anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters. */

// Brutforce Approach TC - O(Nlog(N)), SC - O(N)
class Solution {
    private String sortString(String s)
    {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        s = sortString(s);
        t = sortString(t);
        for(int i = 0;i<s.length();i++)
        {
            if(s.charAt(i) != t.charAt(i)) return false;
        }
        return true;
    }
}

// Optimal Approach TC - O(N), SC - O(1)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++)
        {
            freq[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++)
        {
            if(freq[i] != 0) return false;
        }
        return true;
    }
}

// Optimal Approach TC - O(N), SC - O(k)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(int i=0;i<t.length();i++)
        {
            char ch = t.charAt(i);
            if(!map.containsKey(ch) || map.get(ch) == 0) return false;
            map.put(ch, map.get(ch)-1);   
        }
        return true;
    }
}
