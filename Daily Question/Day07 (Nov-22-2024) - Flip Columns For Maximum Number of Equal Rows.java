/* 1072. Flip Columns For Maximum Number of Equal Rows - https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows
You are given an m x n binary matrix matrix.

You can choose any number of columns in the matrix and flip every cell in that column (i.e., Change the value of the cell from 0 to 1 or vice versa).

Return the maximum number of rows that have all values equal after some number of flips.

Example 1:

Input: matrix = [[0,1],[1,1]]
Output: 1
Explanation: After flipping no values, 1 row has all values equal.
Example 2:

Input: matrix = [[0,1],[1,0]]
Output: 2
Explanation: After flipping values in the first column, both rows have equal values.
Example 3:

Input: matrix = [[0,0,0],[0,0,1],[1,1,0]]
Output: 2
Explanation: After flipping values in the first two columns, the last two rows have equal values.
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is either 0 or 1. */

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int[] row : matrix)
        {
            StringBuilder rowValue = new StringBuilder();
            StringBuilder flipedrowValue = new StringBuilder();
            for(int col : row)
            {
                rowValue.append(col);
                flipedrowValue.append(1-col);
            }
            String rowString = rowValue.toString();
            String flippedString = flipedrowValue.toString();
            map.put(rowString, map.getOrDefault(rowString, 0)+1);
            map.put(flippedString, map.getOrDefault(flippedString, 0)+1);
        }
        int maxRows = 0; 
        for(int val : map.values())
        {
            if(maxRows < val) maxRows = val; 
        }
        return maxRows;
    }
}
