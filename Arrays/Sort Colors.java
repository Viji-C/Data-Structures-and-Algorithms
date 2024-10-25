/* 75. Sort Colors https://leetcode.com/problems/sort-colors/

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2. */

// Brutforce Approach

class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i=0;i<len;i++)
        {
            if(nums[i] == 0)
            {
                count0++; 
            }
            else if(nums[i] == 1)
            {
                count1++; 
            }
            else
            {
                count2++;
            }
        }
        int i =0;
        for(i=0;i<len;i++)
        {
            if(i<count0)
            {
                nums[i] = 0;
            }
            else if(i<count1+count0)
            {
                nums[i] = 1;
            }
            else
            {
                nums[i] = 2;
            }
        }
    }
}

// Optimal Approach

class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int high = len-1;
        int low = 0, mid = 0;
        while(mid<=high)
        {
            if(nums[mid] == 0)
            {
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            }
            else if(nums[mid] == 1)
            {
                mid++;
            }
            else
            {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}