/* 1248. Count Number of Nice Subarrays - leetcode.com/problems/count-number-of-nice-subarrays/
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
 

Constraints:

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length */

// Brutforce Approach - TC - O(N^2), SC - O(1)
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int ans = 0;
        for(int i=0;i<len;i++)
        {
            int count=0;
            for(int j=i;j<len;j++)
            {
                if(nums[j]%2!=0)
                {
                    count++;
                }
                if(count == k)
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}

// Better Approach - TC - O(N), SC - O(N)
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);
        int oddCount = 0, ans = 0;
        for(int num : nums)
        {
            if(num%2!=0) oddCount++;
            if(prefixSum.containsKey(oddCount-k))
            {
                ans += prefixSum.get(oddCount-k);
            }
            prefixSum.put(oddCount, prefixSum.getOrDefault(oddCount, 0)+1);
        }
        return ans;
    }
}

// Optimal Approach TC - O(2N), SC - O(1)
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }
    private int helper(int[] nums, int k)
    {
        int len = nums.length;
        int sum = 0,right =0, left = 0,count =0;
        if(k < 0) return 0;
        while(right<len)
        {
            if(nums[right]%2!=0) k--;
            while(k<0)
            {
                if(nums[left]%2!=0) k++;
                left++;
            }
            count = count + (right - left +1); 
            right++;
        }
        return count;
    }
}