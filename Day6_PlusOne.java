/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 */
public class Day6_PlusOne {
    public int[] plusOne(int[] digits) {
        int c = 1;
        for (int i= digits.length - 1; i>=0; i--) {
            digits[i] += c;
            
            if (digits[i] >= 10) {
                c = digits[i] / 10;
                digits[i] = digits[i] % 10;
            } else {
                c = 0;
            }
        }
        
        if (c == 1) {
            int res[] = new int[digits.length + 1];
            res[0] = c;
            
            for (int i=0; i<digits.length; i++)
                res[i+1] = digits[i];
            
            return res;
        }
        
        return digits;
    }
}