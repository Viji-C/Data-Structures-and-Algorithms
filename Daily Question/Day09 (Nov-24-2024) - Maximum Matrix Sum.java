/* 1975. Maximum Matrix Sum - https://leetcode.com/problems/maximum-matrix-sum/
You are given an n x n integer matrix. You can do the following operation any number of times:

Choose any two adjacent elements of matrix and multiply each of them by -1.
Two elements are considered adjacent if and only if they share a border.

Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above.

Example 1:

Input: matrix = [[1,-1],[-1,1]]
Output: 4
Explanation: We can follow the following steps to reach sum equals 4:
- Multiply the 2 elements in the first row by -1.
- Multiply the 2 elements in the first column by -1.
Example 2:


Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
Output: 16
Explanation: We can follow the following step to reach sum equals 16:
- Multiply the 2 last elements in the second row by -1.

Constraints:

n == matrix.length == matrix[i].length
2 <= n <= 250
-105 <= matrix[i][j] <= 105 */

// Intution is count negatives if it is even all number will be turned to be positive, If negative count is odd get min abs value
// then sum - 2*minabsvalue 

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        long maxSum = 0, minabsValue = Long.MAX_VALUE, negatives = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long val = matrix[i][j];
                maxSum += Math.abs(val);
                if(val < 0) negatives++;
                minabsValue = Long.min(minabsValue, Math.abs(val));
            }
        }
        if(negatives%2 != 0) 
        {
            maxSum = maxSum - (2*minabsValue);
        }
        return maxSum;
    }
}
