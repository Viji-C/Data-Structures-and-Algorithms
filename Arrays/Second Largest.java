/* Second Largest - https://www.geeksforgeeks.org/problems/second-largest

Given an array arr, return the second largest element from an array. If the second largest element doesn't exist then return -1.

Note: The second largest element should not be equal to the first largest.

Examples:

Input: arr = [12, 35, 1, 10, 34, 1]
Output: 34
Explanation: The largest element of the array is 35 and the second largest element is 34.
Input: arr = [10, 10]
Output: -1
Explanation: The largest element of the array is 10 and the second largest element does not exist..
Constraints:
2 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105

 */

// Brute Force Approach TC - O(Nlog(N))

class Solution {
    public static int secondLargest(int[] arr) {
        Arrays.sort(arr);
        int largest = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != largest) {
                return arr[i];
            }
        }
        return -1; 
    }
}

// Better Approach TC - O(N)
class Solution {
    public int getSecondLargest(int[] arr) {
        int len = arr.length;
        int maxValue = Arrays.stream(arr).max().getAsInt();
        int secondMax = Integer.MIN_VALUE;
        for(int i=0;i<len;i++)
        {
            if(arr[i] < maxValue && secondMax < arr[i])
            {
                secondMax = arr[i];
            }
        }
        return secondMax == Integer.MIN_VALUE ? -1 : secondMax;
    }
}

// Optimal Approach - TC - O(N)

class Solution {
    public int getSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] > largest)
            {
                secondLargest = largest;
                largest = arr[i];
            }
            else if(arr[i] < largest && secondLargest < arr[i])
            {
                secondLargest = arr[i];
            }
        }
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }
}