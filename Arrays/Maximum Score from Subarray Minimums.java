/* Maximum Score from Subarray Minimums - https://www.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/0 

Given an array arr[], with 0-based indexing, select any two indexes, i and j such that i < j. From the subarray arr[i...j], select the smallest and second smallest numbers and add them, you will get the score for that subarray. Return the maximum possible score across all the subarrays of array arr[].

Examples :

Input : arr[] = [4, 3, 1, 5, 6]
Output : 11
Explanation : Subarrays with smallest and second smallest are:- [4, 3] smallest = 3,second smallest = 4
[4, 3, 1] smallest = 1, second smallest = 3
[4, 3, 1, 5] smallest = 1, second smallest = 3
[4, 3, 1, 5, 6] smallest = 1, second smallest = 3
[3, 1] smallest = 1, second smallest = 3
[3, 1, 5] smallest = 1, second smallest = 3
[3, 1, 5, 6] smallest = 1, second smallest = 3
[1, 5] smallest = 1, second smallest = 5
[1, 5, 6] smallest = 1, second smallest = 5
[5, 6] smallest = 5, second smallest = 6
Maximum sum among all above choices is, 5 + 6 = 11.
Input : arr[] = [5, 4, 3, 1, 6] 
Output : 9
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
2 ≤ arr.size ≤ 105
1 ≤ arr[i] ≤ 106 */

// Brutforce Approach 

class Solution {
    // Function to find pair with maximum sum
    public int pairWithMaxSum(List<Integer> arr) {
        int len = arr.size();
        int sum = 0;
        for(int i=0;i<len;i++)
        {
            for(int j=i+1;j<len;j++)
            {
                int min1 = Integer.MAX_VALUE;
                int min2 = Integer.MAX_VALUE;
                for(int k=i;k<=j;k++)
                {
                    if(min1>arr.get(k))
                    {
                        min2 = min1;
                        min1 = arr.get(k);
                    }
                    else if(min2>arr.get(k))
                    {
                        min2=arr.get(k);
                    }
                }
                sum = Math.max(sum, min1+min2);
            }
        }
        return sum;
    }
}

// Better Approach

class Solution {
    // Function to find pair with maximum sum
    public int pairWithMaxSum(List<Integer> arr) {
        int len = arr.size();
        int sum = 0;
        for(int i=0;i<len;i++)
        {
            for(int j=i+1;j<len;j++)
            {
                List<Integer> list = new ArrayList<>(arr.subList(i,j+1));
                Collections.sort(list);
                int min1 = list.get(0);
                int min2 = list.get(1);
                sum = Math.max(sum,min1+min2);
            }
        }
        return sum;
    }
}

// Optimal Approach 

class Solution {
    // Function to find pair with maximum sum
    public int pairWithMaxSum(List<Integer> arr) {
        int len = arr.size();
        int sum = 0;
        for(int i=0;i<len-1;i++)
        {
            sum = Math.max(sum, arr.get(i)+arr.get(i+1));
        }
        return sum;
    }
}