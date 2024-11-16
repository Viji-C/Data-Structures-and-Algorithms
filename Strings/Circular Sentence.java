/* 2490. Circular Sentence - https://leetcode.com/problems/circular-sentence
A sentence is a list of words that are separated by a single space with no leading or trailing spaces.

For example, "Hello World", "HELLO", "hello world hello world" are all sentences.
Words consist of only uppercase and lowercase English letters. Uppercase and lowercase English letters are considered different.

A sentence is circular if:

The last character of a word is equal to the first character of the next word.
The last character of the last word is equal to the first character of the first word.
For example, "leetcode exercises sound delightful", "eetcode", "leetcode eats soul" are all circular sentences. However, "Leetcode is cool", "happy Leetcode", "Leetcode" and "I like Leetcode" are not circular sentences.

Given a string sentence, return true if it is circular. Otherwise, return false.

Example 1:

Input: sentence = "leetcode exercises sound delightful"
Output: true
Explanation: The words in sentence are ["leetcode", "exercises", "sound", "delightful"].
- leetcode's last character is equal to exercises's first character.
- exercises's last character is equal to sound's first character.
- sound's last character is equal to delightful's first character.
- delightful's last character is equal to leetcode's first character.
The sentence is circular.
Example 2:

Input: sentence = "eetcode"
Output: true
Explanation: The words in sentence are ["eetcode"].
- eetcode's last character is equal to eetcode's first character.
The sentence is circular.
Example 3:

Input: sentence = "Leetcode is cool"
Output: false
Explanation: The words in sentence are ["Leetcode", "is", "cool"].
- Leetcode's last character is not equal to is's first character.
The sentence is not circular. */

// Brutforce Approach - TC - O(N+k), SC - O(k) - due to split takes string space
class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] list = sentence.trim().split(" ");
        int len = list.length;
        if(list[0].charAt(0) != list[len-1].charAt(list[len-1].length()-1)) return false;
        for(int i=1;i<len;i++)
        {
            String w1 = list[i-1];
            String w2 = list[i];
            if(w1.charAt(w1.length()-1) != w2.charAt(0)) return false;
        }
        return true;
    }
}

//Better Approach - TC - O(N), SC - O(1)
class Solution {
    public boolean isCircularSentence(String sentence) {
        int len = sentence.length();
        if(sentence.charAt(0) != sentence.charAt(len-1)) return false;
        for(int i=1;i<len;i++)
        {
            if(sentence.charAt(i) == ' ' && sentence.charAt(i-1) != sentence.charAt(i+1)) return false;
        }
        return true;
    }
}

// Optimal Approach TC - O(N), SC - O(1)
class Solution {
    public boolean isCircularSentence(String sentence) {
        int len = sentence.length();
        if(sentence.charAt(0) != sentence.charAt(len-1)) return false;
        int k = sentence.indexOf(" ");
        if(k == -1) return true;
        while(k!=-1)
        {
            if(sentence.charAt(k-1) != sentence.charAt(k+1)) 
            {
                return false;
            }
            k = sentence.indexOf(" ", k+1);
        }
        return true;
    }
}