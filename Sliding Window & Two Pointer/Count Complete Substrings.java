/* 2953. Count Complete Substrings - https://leetcode.com/problems/count-complete-substrings/
You are given a string word and an integer k.

A substring s of word is complete if:

Each character in s occurs exactly k times.
The difference between two adjacent characters is at most 2. That is, for any two adjacent characters c1 and c2 in s, the absolute difference in their positions in the alphabet is at most 2.
Return the number of complete substrings of word.

A substring is a non-empty contiguous sequence of characters in a string.

Example 1:

Input: word = "igigee", k = 2
Output: 3
Explanation: The complete substrings where each character appears exactly twice and the difference between adjacent characters is at most 2 are: igigee, igigee, igigee.
Example 2:

Input: word = "aaabbbccc", k = 3
Output: 6
Explanation: The complete substrings where each character appears exactly three times and the difference between adjacent characters is at most 2 are: aaabbbccc, aaabbbccc, aaabbbccc, aaabbbccc, aaabbbccc, aaabbbccc.

Constraints:

1 <= word.length <= 105
word consists only of lowercase English letters.
1 <= k <= word.length */

// Brutforce Approach TC - O(N^3), SC - O(N)
class Solution {
    public int countCompleteSubstrings(String word, int k) {
        int len = word.length();
        int count = 0;
        for(int i=0;i<len;i++)
        {
            for(int j=i;j<len;j++)
            {
                if(isCompleteSubstring(word.substring(i,j+1), k))
                {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isCompleteSubstring(String s, int k)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(int freq : map.values())
        {
            if (freq != k) return false;
        }
        for(int i=1;i<s.length();i++)
        {
            if(Math.abs(s.charAt(i) - s.charAt(i-1)) > 2) return false;
        }
        return true;
    }
}

// Brtforce Approach 
class Solution {
    public int countCompleteSubstrings(String word, int k) {
        int totalUniqueChars = (int) word.chars().distinct().count();
        int count = 0;

        for (int uniqueChars = 1; uniqueChars <= totalUniqueChars; uniqueChars++) {
            int windowSize = uniqueChars * k;
            if (windowSize > word.length()) {
                break;
            }

            int[] charToCount = new int[26];
            for (int i = 0; i < windowSize; i++) {
                charToCount[word.charAt(i) - 'a']++;
            }

            if (isEqualKTimes(charToCount, k) && areAdjacentCharsValid(word, 0, windowSize - 1)) {
                count++;
            }

            for (int start = 1; start <= word.length() - windowSize; start++) {
                charToCount[word.charAt(start - 1) - 'a']--;
                charToCount[word.charAt(start + windowSize - 1) - 'a']++;

                if (isEqualKTimes(charToCount, k) && areAdjacentCharsValid(word, start, start + windowSize - 1)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isEqualKTimes(int[] charToCount, int k) {
        for (int count : charToCount) {
            if (count != 0 && count != k) {
                return false;
            }
        }
        return true;
    }

    private boolean areAdjacentCharsValid(String word, int start, int end) {
        for (int i = start; i < end; i++) {
            if (Math.abs(word.charAt(i) - word.charAt(i + 1)) > 2) {
                return false;
            }
        }
        return true;
    }
}

