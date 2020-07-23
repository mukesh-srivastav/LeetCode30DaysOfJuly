/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class Day23_SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int res[] = new int[2];
        
        int xor = 0;
        
        for (int i : nums)
            xor ^= i;
        //Get the first set bit from right. for example if xor = 6 (110), We will get 10 i.e. 2, so check 2nd bit set element in array, which will be first element, xoring upon the elements which doesn't have 2nd element set will give second element. xor can not be zero because all elements aren't same. 
        xor &= -xor;
        
        for (int i: nums) {
            if ((i & xor) == 0)
                res[0] ^= i;
            else
                res[1] ^= i;
        }
        
        return res;
    }
}