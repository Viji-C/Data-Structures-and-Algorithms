/* 76. Minimum Window Substring - https://leetcode.com/problems/minimum-window-substring/
Given two strings s and t of lengths m and n respectively, return the minimum window 
substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters. */

// Brutforce Approach - TC - O(N^3), SC - O(N)
class Solution {
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int len = Integer.MAX_VALUE;
        String st = "";
        for(int i=0;i<slen;i++)
        {
            for(int j=i;j<slen;j++)
            {
                String sstr = s.substring(i, j+1);
                if(isvalid(sstr, t, tlen))
                {
                    if(len > sstr.length())
                    {
                        st = sstr;
                        len = sstr.length();
                        break;
                    }
                }
            }
        }
        return st;
    }
    private boolean isvalid(String sstr, String t, int tlen)
    {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : t.toCharArray())
        {
            hm.put(ch, hm.getOrDefault(ch,0)+1);
        }
        int c = 0;
        for(char ch : sstr.toCharArray())
        {
            if(hm.get(ch)!= null) 
            {
                hm.put(ch, hm.get(ch)-1);
                if(hm.get(ch) == 0) hm.remove(ch);
                c++;
            }
        }
        return (c == tlen);
    }
}


// Better Approach - TC - O(2N), SC - O(M)
class Solution {
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length(), r=0, l=0, cnt=0;
        int minlen = Integer.MAX_VALUE, start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        while(r<slen)
        {
            char rchar = s.charAt(r);
            if(map.containsKey(rchar))
            {
                if(map.get(rchar) > 0) cnt++;
                map.put(rchar, map.get(rchar)-1);
            }
            while(cnt == tlen)
            {
                if(minlen > r-l+1)
                {
                    minlen = r-l+1;
                    start = l;
                }
                char lchar = s.charAt(l);
                if(map.containsKey(lchar)) 
                {
                    map.put(lchar, map.getOrDefault(lchar, 0)+1);
                    if(map.get(lchar) > 0) cnt--;
                }
                l++;
            }
            r++;
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start+minlen);
    }
}

// Optimal Approach TC - O(2N), SC - O(256)
class Solution {
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length(), r=0, l=0, cnt=0;
        int minlen = Integer.MAX_VALUE, start = 0;
        int[] hash = new int[256];
        for(char ch : t.toCharArray())
        {
            hash[ch - 'A']++;
        }
        while(r<slen)
        {
            char rchar = s.charAt(r);
            if(hash[rchar - 'A'] > 0) cnt++;
            hash[rchar - 'A']--;
            while(cnt == tlen)
            {
                if(minlen > r-l+1)
                {
                    minlen = r-l+1;
                    start = l;
                }
                char lchar = s.charAt(l);
                hash[lchar - 'A']++;
                if(hash[lchar - 'A'] > 0) cnt--;
                l++;
            }
            r++;
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start+minlen);
    }
}