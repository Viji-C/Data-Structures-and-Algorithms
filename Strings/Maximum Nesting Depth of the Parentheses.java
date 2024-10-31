/* 1614. Maximum Nesting Depth of the Parentheses - leetcode.com/problems/maximum-nesting-depth-of-the-parentheses - 
Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

Example 1:

Input: s = "(1+(2*3)+((8)/4))+1"

Output: 3

Explanation:

Digit 8 is inside of 3 nested parentheses in the string.

Example 2:

Input: s = "(1)+((2))+(((3)))"

Output: 3

Explanation:

Digit 3 is inside of 3 nested parentheses in the string.

Example 3:

Input: s = "()(())((()()))"

Output: 3

Constraints:

1 <= s.length <= 100
s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
It is guaranteed that parentheses expression s is a VPS. */

// Brutforce Approach - TC - O(N), SC - O(N)
class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
            {
                st.push(ch);
            }
            else if(ch == ')')
            {
                st.pop();
            }
            count = Math.max(count, st.size());
        }
        return count;
    }
}

// Better Approach TC - O(N), SC - O(1)
class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int maxcount = 0;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
            {
                count++;
                maxcount = Math.max(count, maxcount);
            }
            else if(ch == ')')
            {
                count--;
            }
        }
        return maxcount;
    }
}

// Optimal Approach TC - O(N), SC - O(1)
class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int maxcount = 0;
        for(char ch : s.toCharArray())
        {
            if(ch == '(')
            {
                count++;
                maxcount = Math.max(count, maxcount);
            }
            else if(ch == ')')
            {
                count--;
            }
        }
        return maxcount;
    }
}