/* 992. Subarrays with K Different Integers - https://leetcode.com/problems/subarrays-with-k-different-integers
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i], k <= nums.length */

// Brutforce Approach - TC - O(N^2), SC - O(N)
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int len = nums.length;
        int count=0;
        for(int i=0;i<len;i++)
        {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=i;j<len;j++)
            {
                map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
                if(isGoodArray(map, k)) count++;
            }
        }
        return count;
    }

    private boolean isGoodArray(HashMap<Integer, Integer> map, int k)
    {
        if(map.size() < k || map.size() > k) return false;
        return true;
    }
}

// Optimal Approach - TC - O(N), SC - O(K)
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }

    private int helper(int[] nums, int k)
    {
        if(k<1) return 0;
        int len = nums.length;
        int count=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int right = 0, left = 0;
        for(right=0;right<len;right++)
        {
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
            while(map.size() > k)
            {
                map.put(nums[left], map.get(nums[left]) -1);
                if(map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }
            count += right - left + 1; 
        }
        return count;
    }
}