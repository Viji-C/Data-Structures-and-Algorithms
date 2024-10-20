/**  https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
Two Sum II - Input Array Is Sorted

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
**/

// Brutforce Sollution - Using two loops

class Solution {
    public int[] twoSum(int[] numbers, int target) {
	int[] ans = new int[2];
        for(int i=0;i<numbers.length;i++)
        {
            for(int j=i+1;j<numbers.length;j++)
            {
                if(numbers[i]+numbers[j] == target)
                {
                    ans[0] = i+1;
                    ans[1] = j+1;
                }
            }
        }
        return ans;
    }
}

// Better Sollution - Hash Map

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int moreNeeded = target-nums[i];
            if(map.containsKey(moreNeeded))
            {
                ans[0] = map.get(moreNeeded)+1;
                ans[1] = i+1;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}

// Optimal Solution - Using Two Pointer Approach

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int start=0;
        int last = numbers.length-1;
        while(start<last)
        {
            int sum = numbers[start] + numbers[last];
            if(sum == target)
            {
                ans[0] = start+1;
                ans[1] = last+1;
                break;
            }
            else if(sum < target)
            {
                start++;
            }
            else
            {
                last--;
            }
        }
        return ans;
    }
}
