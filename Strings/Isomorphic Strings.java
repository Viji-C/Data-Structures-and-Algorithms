/* 205. Isomorphic Strings - leetcode.com/problems/isomorphic-strings
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "foo", t = "bar"

Output: false

Explanation:

The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:

Input: s = "paper", t = "title"

Output: true

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character. */

// Brutforce Approach

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        HashMap<Character, Character> mp = new HashMap<>();
        mp.put(s.charAt(0), t.charAt(0));
        for(int i= 1;i<len;i++)
        {
            if(mp.containsKey(s.charAt(i)) && mp.get(s.charAt(i)) != t.charAt(i))
            {
                return false;
            }
            else if(mp.containsValue(t.charAt(i)) && !mp.containsKey(s.charAt(i)))
            {
                return false;
            }
            else
            {
                mp.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}

// Optimal Sollution (Using Arrays as HashMap for ASCII Characters)

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] mapST = new int[256];
        int[] mapTS = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapST[charS] == 0 && mapTS[charT] == 0) {
                mapST[charS] = charT;
                mapTS[charT] = charS;
            } else if (mapST[charS] != charT || mapTS[charT] != charS) {
                return false;
            }
        }
        return true;
    }
}
