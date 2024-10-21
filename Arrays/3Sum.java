/** 
15. 3Sum - https://leetcode.com/problems/3sum/

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105 **/

// Brute Force Approach 

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> tripletlists = new ArrayList<>();
        // Set<List<Integer>> tripletset = new HashSet<>();
        for(int i=0;i<length;i++)
        {
            for(int j=i+1;j<length;j++)
            {
                for(int k=j+1;k<length;k++)
                {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0)
                    {
                        List<Integer> triplets = new ArrayList<>();
                        triplets.add(nums[i]); 
                        triplets.add(nums[j]); 
                        triplets.add(nums[k]); 
                        Collections.sort(triplets);
                        // tripletset.add(triplets);
                        if(!tripletlists.contains(triplets))
                        {
                            tripletlists.add(triplets);
                        }
                    }
                }
            }
        }
        // List<List<Integer>> tripletlists = new ArrayList<>(tripletset);
        return tripletlists;
    }
}

// Better Approach (Using HashSet to reduce one loop)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> tripletlists = new ArrayList<>();
        for(int i=0;i<length;i++)
        {
            Set<Integer> set = new HashSet<>();
            for(int j=i+1;j<length;j++)
            {
                int third = -(nums[i] + nums[j]);
                if(set.contains(third))
                {
                    List<Integer> temp = Arrays.asList(nums[i],nums[j],third);
                    Collections.sort(temp);
                    if(!tripletlists.contains(temp)) tripletlists.add(temp);
                }
                set.add(nums[j]);
            }
        }
        return tripletlists;
    }
}

// Optimal Approach 

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> tripletlists = new ArrayList<>();

        for(int i=0;i<length;i++)
        {
            if(i!=0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = length-1;
            while(j<k)
            {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0) 
                {
                    j++;
                }
                else if(sum > 0) 
                {
                    k--;
                }
                else
                {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    tripletlists.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return tripletlists;
    }
}