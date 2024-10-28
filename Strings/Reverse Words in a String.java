/* 151. Reverse Words in a String - https://leetcode.com/problems/reverse-words-in-a-string

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
  */

// Better Approach TC - O(N), SC - O(N)
class Solution {
    public String reverseWords(String s) {
        String[] arrOfStr = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for(int i=arrOfStr.length-1;i>=0;i--)
        {
            String str = arrOfStr[i];
            sb.append(str);
            if(i>0)
            {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}

// Optimal Approach

class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int len = removeExtraSpaces(chars);
        reverse(chars, 0, len - 1);
        int start = 0;
        for(int end = 0; end < len; end++)
        {
            if(chars[end] == ' ')
            {
                reverse(chars, start, end-1);
                start = end+1;
            }
        }
        reverse(chars, start, len-1);
        return new String(chars, 0, len);
    }
    private void reverse(char[] chars,int left,int right)
    {
        while(left < right)
        {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
    private int removeExtraSpaces(char[] chars)
    {
        int i=0,j=0;
        while(j < chars.length)
        {
            while(j < chars.length && chars[j] == ' ') j++;
            while(j < chars.length && chars[j] != ' ') chars[i++] = chars[j++];
            while(j < chars.length && chars[j] == ' ') j++;
            if(j < chars.length) chars[i++] = ' ';
        }
        return i;
    }
}