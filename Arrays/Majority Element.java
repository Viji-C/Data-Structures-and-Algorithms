/* 169. Majority Element - https://leetcode.com/problems/majority-element/
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
  */

// Brutforce Approach TC - O(Nlog(N)) SC - O(1)
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1] == nums[i])
            {
                count++;
                if(count>nums.length/2)
                {
                    return nums[i];
                }
            }
            else
            {
                count = 1;
            }
        }
        return nums[0];
    }
}

// Better Approach TC O(N) SC - O(N)

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            if(map.get(nums[i]) > nums.length/2)
            {
                return nums[i];
            }
        }
        return nums[0];
    }
}

// Optimal Approach  (Moore's Voting Algorith)

class Solution {
    public int majorityElement(int[] nums) {
        int l = nums.length;
        int cnt = 0;
        int element = 0;
        for(int i=0;i<l;i++)
        {
            if(cnt == 0)
            {
                cnt = 1;
                element = nums[i];
            }
            else if (nums[i] != element) cnt--;
            else cnt++;
        }
        int count = 0;
        for(int i=0;i<l;i++)
        {
            if(element == nums[i])
            {
                count++;
            }
        }
        if(count>l/2)
        {
            return element;
        }
        return nums[0];
    }
}