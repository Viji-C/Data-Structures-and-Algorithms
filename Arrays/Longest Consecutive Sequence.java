/* Longest Consecutive Sequence - https://leetcode.com/problems/longest-consecutive-sequence/
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109 */

// Brutforce Approach TC - O(N^2)

class Solution {
    private boolean linearSearch(int[] a, int x)
    {
        int alength = a.length;
        for(int i=0;i<alength;i++)
        {
            if(a[i] == x) return true;
        }
        return false;
    }
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int maxCount = 1;
        for(int i=0;i<nums.length-1;i++)
        {
            int x = nums[i];
            int count = 1;
            while(linearSearch(nums, x+1))
            {
                x++;
                count++;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}

// Better Approach TC - O(Nlog(N))
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int maxCount = 1, count = 1;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i+1] - nums[i] == 1)
            {
                count++;
                maxCount = Math.max(count, maxCount);
            }
            else if(nums[i+1] == nums[i])
            {
                continue;
            }
            else
            {
                count = 1;
            }
        }
        return maxCount;
    }
}

// Optimal Approach TC - O(N), SC - O(N)

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> numSet = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            numSet.add(nums[i]);
        }
        int maxCount = 0;
        for(int num : numSet)
        {
            if(!numSet.contains(num-1))
            {
                int count = 1;
                while(numSet.contains(num+1))
                {
                    num++;
                    count++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}