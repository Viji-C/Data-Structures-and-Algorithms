/* 215. Kth Largest Element in an Array - https://leetcode.com/problems/kth-largest-element-in-an-array/

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4 */

// Brutforce Approach
// TC - O(N log(N)) - sorting , SC - O(1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len-k];
    }
}

// Better Approach
// TC O(N) - iteration and adding element in the queue, SC - O(N)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums)
        {
            pq.add(num);
        }
        for(int i=1;i<k;i++)
        {
            pq.poll();
        }
        return pq.peek();
    }
}

// Optimal Approach
// TC - O(Nlog(k)), SC - O(N)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums)
        {
            pq.add(num);
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        return pq.peek();
    }
}