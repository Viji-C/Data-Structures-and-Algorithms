/* 215. Kth Largest Element in an Array - https://leetcode.com/problems/kth-largest-element-in-an-array/

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4 */

// Brutforce Approach

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        int ans = -1;
        int i = 0;
        for(int num : nums)
        {
            if(len-k == i)
            {
                ans = num;
            }
            i++;
        }
        return ans;
    }
}