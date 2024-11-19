/* You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
Example 2:

Input: nums = [4,4,4], k = 3
Output: 0
Explanation: The subarrays of nums with length 3 are:
- [4,4,4] which does not meet the requirements because the element 4 is repeated.
We return 0 because no subarrays meet the conditions.

Constraints:

1 <= k <= nums.length <= 105
1 <= nums[i] <= 105 */

// Brutforce Approach TC - O(N*k), SC - O(K)
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<=len-k;i++)
        {
            Set<Integer> set = new HashSet<>();
            int sum = 0;
            for(int j=i;j<i+k;j++)
            {
                if(!set.contains(nums[j]))
                {
                    set.add(nums[j]);
                    sum += nums[j];
                }
                else 
                {
                    sum = 0;
                    break;
                }
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}


// Better Approach TC - O(N), SC - O(K) - using sliding window
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;
        long maxSum = 0;
        HashSet<Integer> set = new HashSet<>();
        long sum = 0;
        int left = 0;
        for(int right=0;right<len;right++)
        {
            while(set.contains(nums[right]))
            {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            sum += nums[right];
            if(right - left + 1 == k)
            {
                maxSum = Math.max(maxSum, sum);
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
        }
        return maxSum;
    }
}

// Optimal Approach TC - O(N), SC - O(N)
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;
        long maxSum = 0;
        long sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int right = 0; right < len; right++) 
        {
            sum += nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            
            if (right >= k - 1) 
            {
                if (map.size() == k) 
                {
                    maxSum = Math.max(maxSum, sum);
                }
                
                int left = right - k + 1;
                sum -= nums[left];
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) 
                {
                    map.remove(nums[left]);
                }
            }
        }
        
        return maxSum;
    }
}