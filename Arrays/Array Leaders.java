/* Array Leaders - https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
You are given an array arr of positive integers. Your task is to find all the leaders in the array. An element is considered a leader if it is greater than or equal to all elements to its right. The rightmost element is always a leader.

Examples:

Input: arr = [16, 17, 4, 3, 5, 2]
Output: [17, 5, 2]
Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.
Input: arr = [10, 4, 2, 4, 1]
Output: [10, 4, 4, 1]
Explanation: Note that both of the 4s are in output, as to be a leader an equal element is also allowed on the right. side
Input: arr = [5, 10, 20, 40]
Output: [40]
Explanation: When an array is sorted in increasing order, only the rightmost element is leader.
Input: arr = [30, 10, 10, 5]
Output: [30, 10, 10, 5]
Explanation: When an array is sorted in non-increasing order, all elements are leaders.
Constraints:
1 <= arr.size() <= 106
0 <= arr[i] <= 106 */

// Brutforce Approach TC - O(N^2) SC - O(1)

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int len = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<len;i++)
        {
            for(int j=len-1;j>=i;j--)
            {
                if(arr[i] < arr[j])
                {
                    break;
                }
                else if(i==j)
                {
                    ans.add(arr[i]);
                }
            }
        }
        return ans;
    }
}

// Optimal Approach TC O(N), SC - O(1)

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int len = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[len-1]);
        for(int i=len-2;i>=0;i--)
        {
            if(arr[i]>=ans.get(ans.size()-1)) 
            {
                ans.add(arr[i]);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}