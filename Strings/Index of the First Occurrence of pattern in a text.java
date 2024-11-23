/* Index of the First Occurrence of pattern in a text - https://www.geeksforgeeks.org/problems/index-of-the-first-occurrence-of-pattern-in-a-text/1
Given two strings text and pattern, find the first index where pattern exactly matches with any substring of text. 

Return -1 if pattern doesn't exist as a substring in text.

Example 1:

Input:
text = gffgfg
pattern = gfg
Output: 3
Explanation:  Considering 0-based indexing, substring of text from 3rd to last index is gfg.
Example 2:

Input:
text = gffggg
pattern = gfg
Output: -1
Explanation: pattern "gfg" does not exist in the text.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findMatching() which takes the strings text and pattern as the input parameters and returns the first index of matching.

Expected Time Complexity: O(|text| * |pattern|)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ |text|, |pattern| ≤  103 */

// Brutforce Approach TC - O(N*M), SC - O(1)
class Solution {
    public int findMatching(String text, String pat) {
        // Code here
        int plen = pat.length();
        int tlen = text.length();
        int c = 0, j = 0;
        for(int i=0;i<tlen;i++)
        {
            if(text.charAt(i) == pat.charAt(j)){
                j++;
                if(j == plen) return i-j+1;
            }
            else
            {
                i = i-j;
                j=0;
            }
        }
        return -1;
    }
}

// Using Inbuilt funtion
class Solution {
    public int findMatching(String text, String pattern) {
        return text.indexOf(pattern);
    }
}
