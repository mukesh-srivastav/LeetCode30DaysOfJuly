/**
 *  Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1
Example 2:

Input: [2,2,2,0,1]
Output: 0
**/
public class Day25_FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n ==0)
            return -1;
        
        int low = 0, high = n - 1, mid = 0;
        
        while (low <= high) {
            mid = low + (high - low)/2;
            
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[low]) {
                high = mid;
            } else {
                high--;
            }
        }
        
        return nums[low];
    }
}