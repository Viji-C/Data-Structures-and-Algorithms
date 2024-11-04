/* Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15

Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length */

// Brutforce Approach - TC - O(N^2), SC - O(1)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int len = nums.length;
        int count = 0;
        for(int i=0;i<len;i++)
        {
            int sum = 0;
            for(int j=i;j<len;j++)
            {
                sum += nums[j];
                if(sum == goal)
                {
                    count++;
                }
            }
        }
        return count;
    }
}

// Better Approach TC - O(N), SC - O(N)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int len = nums.length;
        int count = 0, sum = 0;
        HashMap<Integer,Integer> prefixsum = new HashMap<>();
        prefixsum.put(0,1);
        for(int i=0;i<len;i++)
        {
            sum += nums[i];
            if(prefixsum.containsKey(sum-goal))
            {
                count = count + prefixsum.get(sum-goal);
            }
            prefixsum.put(sum,prefixsum.getOrDefault(sum,0) + 1);
        }
        return count;
    }
}

// Optimal Approach(Using Sliding window) TC- O(N), SC - O(1)
class Solution {
    private int atMost(int[] arr, int goal) {
        int size = arr.length;
        int count = 0;
        int sum = 0;
        int l = 0;

        for (int r = 0; r < size; r++) {
            sum += arr[r];
            while (sum > goal && l <= r) {
                sum -= arr[l++];
            }
            count += r - l + 1;
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal) - atMost(nums, goal - 1);
    }
}