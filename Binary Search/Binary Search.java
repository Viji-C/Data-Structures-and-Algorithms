/* 704. Binary Search - https://leetcode.com/problems/binary-search/ 
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Constraints:

1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order. */

// Brutforce Approach SC - O(1), TC - O(N)
class Solution {
    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++)
        {
            if(target == nums[i]) return i;
        }
        return -1;
    }
}

// Optimal Sollution SC - O(1), TC - O(logN)
class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int start = 0, end = len-1;
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) start = mid+1;
            else end=mid-1;
        }
        return -1;
    }
}

// Optimal Approach SC - O(N), TC - O(1)
class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }
    private int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, right);
        } else {
            return binarySearch(nums, target, left, mid - 1);
        }
    }
}