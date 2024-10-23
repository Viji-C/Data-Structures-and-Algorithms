/* 3Sum Closest - https://leetcode.com/problems/3sum-closest/

Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

Constraints:

3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104 */

// Brutforce Approach TC = O(n^3) SC - O(1)

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closet = Integer.MAX_VALUE;
        int len = nums.length;
        for(int i=0;i<len;i++)
        {
            for(int j=i+1;j<len;j++)
            {
                for(int k=j+1;k<len;k++)
                {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == target )
                    {
                        return sum;
                    }
                    if(Math.abs(sum-target) < Math.abs(closet-target))
                    {
                        closet = sum;
                    }
                }
            }
        }
        return closet;
    }
}

// Optimal Approach TC - O(N^2), SC - O(1)

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closet = Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<len;i++)
        {
            int j = i+1;
            int k = len-1;
            while(j<k)
            {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) 
                {
                    return sum;
                }
                if(Math.abs(sum-target) < Math.abs(closet - target))
                {
                    closet = sum;
                }
                if(sum < target)
                {
                    j++;
                }
                else
                {
                    k--;
                }
            }
        }
        return closet;
    }
}