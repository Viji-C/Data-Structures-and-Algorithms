/* 451. Sort Characters By Frequency - https://leetcode.com/problems/sort-characters-by-frequency/
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 

Constraints:

1 <= s.length <= 5 * 105
s consists of uppercase and lowercase English letters and digits. */

// Brutforce Approach TC - O(N + klog(k)), SC - O(N)
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        List<Character> chars = new ArrayList<>(map.keySet());
        chars.sort((a,b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        for(char ch : chars)
        {
            int fre = map.get(ch);
            for(int i=0;i<fre;i++)
            {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

// Better Approac TC - O(Nlog(K)), SC - O(N)
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        maxHeap.addAll(frequencyMap.keySet());

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            int frequency = frequencyMap.get(c);
            for (int i = 0; i < frequency; i++) {
                result.append(c);
            }
        }
        return result.toString();
    }
}

// Optimal Approach 
class Solution {
    public String frequencySort(String s) {
        char[] str = s.toCharArray();
        int[] freq = new int[128];
        for (int i = 0; i < str.length; i++) {
            freq[str[i]]++;
        }
        int i=0;
        while(i<str.length) {
            char cmax = '.';  
            for (int j = 0; j < 128; j++) {
                if (freq[j] > freq[cmax]) {
                    cmax = (char) j;
                }
            }
            while (freq[cmax] != 0) {
                str[i++] = cmax;
                freq[cmax]--;
            }
        }
        return new String(str);
    }
}
