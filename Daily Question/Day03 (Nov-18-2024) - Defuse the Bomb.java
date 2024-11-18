/* 1652. Defuse the Bomb - https://leetcode.com/problems/defuse-the-bomb
You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code of length of n and a key k.

To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.

If k > 0, replace the ith number with the sum of the next k numbers.
If k < 0, replace the ith number with the sum of the previous k numbers.
If k == 0, replace the ith number with 0.
As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].

Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!

Example 1:

Input: code = [5,7,1,4], k = 3
Output: [12,10,16,13]
Explanation: Each number is replaced by the sum of the next 3 numbers. The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.
Example 2:

Input: code = [1,2,3,4], k = 0
Output: [0,0,0,0]
Explanation: When k is zero, the numbers are replaced by 0. 
Example 3:

Input: code = [2,4,9,3], k = -2
Output: [12,5,6,13]
Explanation: The decrypted code is [3+9, 2+3, 4+2, 9+4]. Notice that the numbers wrap around again. If k is negative, the sum is of the previous numbers.

Constraints:

n == code.length
1 <= n <= 100
1 <= code[i] <= 100
-(n - 1) <= k <= n - 1 */

// Brutforce Approach  TC - O(N * |k|), SC - O(N)
class Solution {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] ans = new int[len];

        if (k == 0) 
        {
            return ans;
        }

        for (int i = 0; i < len; i++) {
            int sum = 0;
            if (k > 0) 
            {
                for (int j = 1; j <= k; j++) 
                {
                    sum += code[(i + j) % len];
                }
            } 
            else if (k < 0) 
            {
                for (int j = -1; j >= k; j--) 
                {
                    sum += code[(i + j + len) % len];
                }
            }
            ans[i] = sum;
        }
        return ans;
    }
}

// Better Approach TC - O(N), SC - O(N) - using Sliding Window
class Solution {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] ans = new int[len];
        if (k == 0) 
        {
            return ans;
        }

        int start = 1, end = k;
        if(k<0) 
        {
            start = len + k;
            end = len - 1;
        }
        int sum = 0;
        for(int i = start; i<=end; i++)
        {
            sum += code[i];
        }
        for(int i=0;i<len;i++)
        {
            ans[i] = sum;
            sum -= code[start%len];
            sum += code[(end+1) % len];
            start++;
            end++;
        }
        return ans;
    }
}


// Optimal Approach TC - O(N), SC - O(N) - Using PrefixSum
class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        
        if (k == 0) {
            return result; 
        }
        
        int[] extended = new int[n * 2];
        for (int i = 0; i < n; i++) {
            extended[i] = extended[i + n] = code[i];
        }
        
        int[] prefixSum = new int[extended.length + 1];
        for (int i = 0; i < extended.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + extended[i];
        }
        
        for (int i = 0; i < n; i++) {
            if (k > 0) {
                result[i] = prefixSum[i + k + 1] - prefixSum[i + 1];
            } else {
                result[i] = prefixSum[i + n] - prefixSum[i + n + k];
            }
        }
        
        return result;
    }
}
