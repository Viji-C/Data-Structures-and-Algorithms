/* Fruit Into Baskets - geeksforgeeks.org/problems/fruit-into-baskets-1663137462/1
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array of arr[], where arr[i]  is the type of fruit the ith tree produces.
You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow :

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of the baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array of fruits, return the maximum number of fruits you can pick.

Examples:

Input: arr[]= [2, 1, 2]
Output: 3
Explanation: We can pick one fruit from all three trees. Please note that the type of fruits is same in the 1st and 3rd baskets.
Input: arr[] = [3, 1, 2, 2, 2, 2]
Output: 5
Explanation: It's optimal to pick from the last 5 trees. Please note that we do not pick the first basket as we would have to stop at thrid tree which would result in only 2 fruits collected.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1). */

// Brutforce Approach TC - O(N^2), SC - O(1)
class Solution {
    public static int totalFruits(Integer[] arr) {
        // code here
        int len = arr.length;
        int maxlen = 0;
        for(int i=0;i<len;i++)
        {
            Set<Integer> set = new HashSet<>();
            for(int j=i;j<len;j++)
            {
                set.add(arr[j]);
                if(set.size()<=2)
                {
                    maxlen = Math.max(maxlen, j-i+1);
                }
                else
                {
                    break;
                }
            }
        }
        return maxlen;
    }
}

// Better Approach TC - O(2N), SC - O(3)
class Solution {
    public static int totalFruits(Integer[] arr) {
        // code here
        int len = arr.length;
        int maxlen = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int right=0, left=0;
        for(right=0;right<len;right++)
        {
            if(hm.size()<=2)
            {
                hm.put(arr[right], hm.getOrDefault(arr[right], 0)+1);
            }
            while(hm.size()>2)
            {
                hm.put(arr[left], hm.get(arr[left])-1);
                if(hm.get(arr[left]) == 0)
                {
                    hm.remove(arr[left]);
                }
                left++;
            }
            maxlen = Math.max(maxlen, right-left+1);
        }
        return maxlen;
    }
}

// Optimal Approach TC - O(N), SC - O(3)
class Solution {
    public static int totalFruits(Integer[] arr) {
        // code here
        int len = arr.length;
        int maxlen = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int right=0, left=0;
        for(right=0;right<len;right++)
        {
            hm.put(arr[right], hm.getOrDefault(arr[right], 0)+1);
            if(hm.size()<=2)
            {
                maxlen = Math.max(maxlen, right-left+1);
            }
            if(hm.size()>2)
            {
                hm.put(arr[left], hm.get(arr[left])-1);
                if(hm.get(arr[left]) == 0)
                {
                    hm.remove(arr[left]);
                }
                left++;
            }
            
        }
        return maxlen;
    }
}