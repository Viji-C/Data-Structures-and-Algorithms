/* 1861. Rotating the Box - https://leetcode.com/problems/rotating-the-box/
You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:

A stone '#'
A stationary obstacle '*'
Empty '.'
The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.

It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.

Return an n x m matrix representing the box after the rotation described above.

Example 1:

Input: box = [["#",".","#"]]
Output: [["."],
         ["#"],
         ["#"]]

Example 2:
Input: box = [["#",".","*","."],
              ["#","#","*","."]]
Output: [["#","."],
         ["#","#"],
         ["*","*"],
         [".","."]]
Example 3:

Input: box = [["#","#","*",".","*","."],
              ["#","#","#","*",".","."],
              ["#","#","#",".","#","."]]
Output: [[".","#","#"],
         [".","#","#"],
         ["#","#","*"],
         ["#","*","."],
         ["#",".","*"],
         ["#",".","."]]

Constraints:

m == box.length
n == box[i].length
1 <= m, n <= 500
box[i][j] is either '#', '*', or '.'. */

class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] ans = new char[n][m];
        for(char[] row : box)
        {
            int em = n-1;
            for(int j=row.length-1;j>=0;j--)
            {
                if(row[j] == '*')
                {
                    em = j-1;
                }
                else if(row[j] == '#')
                {
                    row[j] = '.';
                    row[em] = '#';
                    em--;
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                ans[j][m-i-1] = box[i][j];
            }
        }
        return ans;
    }
}