/* 1004. Max Consecutive Ones III leetcode.com/problems/max-consecutive-ones-iii - 
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 
Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length */

// Brutforce Approach TC - O(N^2), SC - O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int maxones = 0;
        for(int i=0;i<len;i++)
        {
            int countZero = 0;
            for(int j=i;j<len;j++)
            {
                if(nums[j] == 0) countZero++;
                if(countZero>k) break;
                maxones = Math.max(maxones, j-i+1);
            }
        }
        return maxones;
    }
}

// Better Approach (Using Sliding Window) - TC - O(N), SC - O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int maxones = 0;
        int countZero = 0,right=0,left=0;
        for(right=0;right<len;right++)
        {
            if(nums[right] == 0) countZero++;
            while(countZero > k)
            {
                if(nums[left] == 0) countZero--;
                left++;
            }
            maxones = Math.max(maxones, right-left+1);
        }
        return maxones;
    }
}

// Optimal Approach TC - O(N), SC - O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int right=0,left=0;
        for(right=0;right<len;right++)
        {
            if(nums[right] == 0) k--;
            if(k<0)
            {
                if(nums[left] == 0) k++;
                left++;
            }
        }
        return right-left;
    }
}