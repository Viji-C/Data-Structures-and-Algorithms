/* 796. Rotate String - https://leetcode.com/problems/rotate-string
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false 

Constraints:

1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters. */

// Brutforce Approach TC - (O^2) SC - O(N)
class Solution {
    public boolean rotateString(String s, String goal) {
        int len = s.length();
        String rotated = s;
        for(int i=0;i<len;i++)
        {
            rotated = rotated.substring(1) + rotated.charAt(0);
            if(rotated.equals(goal)) return true;
        }
        return false;
    }
}

// Optimal Approach TC - O(N), SC - O(N)
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        String concatenateString = s+s;
        return concatenateString.contains(goal);
    }
}