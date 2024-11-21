/* Longest valid Parentheses - https://www.geeksforgeeks.org/problems/longest-valid-parentheses5657/1

Given a string str consisting of opening and closing parenthesis '(' and ')'. Find the length of the longest valid parenthesis substring.

A parenthesis string is valid if:

For every opening parenthesis, there is a closing parenthesis.
The closing parenthesis must be after its opening parenthesis.
Examples :

Input: str = ((()
Output: 2
Explaination: The longest valid parenthesis substring is "()".
Input: str = )()())
Output: 4
Explaination: The longest valid parenthesis substring is "()()".
Input: str = ())()
Output: 2
Explaination: The longest valid parenthesis substring is "()".
 */

// Brutforce Approach - Using Stack TC - O(N), SC - O(N)
class Solution{
    static int maxLength(String str){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}

// Optimal Approach - Using Two Pointer
class Solution{
    static int maxLength(String str){
        int maxLen = 0, open = 0, close = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '(') open++;
            else close++;
            if (open == close) {
                maxLen = Math.max(maxLen, 2 * close);
            } else if (close > open) {
                open = close = 0;
            }
        }

        open = close = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == ')') close++;
            else open++;
            if (open == close) {
                maxLen = Math.max(maxLen, 2 * open);
            } else if (open > close) {
                open = close = 0;
            }
        }

        return maxLen;
    }
}