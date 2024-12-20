/* 560. Subarray Sum Equals K - https://leetcode.com/problems/subarray-sum-equals-k
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107 */


// Better Approach O(N^2)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for(int i=0;i<len;i++)
        {
            int sum = 0;
            for(int j=i;j<len;j++)
            {
                sum = sum + nums[j];
                if(sum == k)
                {
                    count++;
                }
            }
        }
        return count;
    }
}

// Optimal Approach - TC O(N), SC - O(N)

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // map.put(0, 1);
        for(int i=0;i<nums.length;i++)
        {
            sum = sum + nums[i];
            if(sum == k)
            {
                count++;
            }
            if(map.containsKey(sum-k))
            {
                count += map.get(sum-k); 
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}