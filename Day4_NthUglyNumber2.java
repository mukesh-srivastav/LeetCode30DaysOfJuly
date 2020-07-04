/**
 * Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.
 */
import java.util.*;
public class Day4_NthUglyNumber2 {
    public int nthUglyNumber(int n) {
        if (n<=0)
            return 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int twoIndex = 0, threeIndex = 0, fiveIndex = 0;
        
        while (list.size() < n) {
            int twosNext = list.get(twoIndex) * 2;
            int threesNext = list.get(threeIndex) * 3;
            int fivesNext = list.get(fiveIndex) * 5;
            
            int min = Math.min(twosNext, Math.min(threesNext, fivesNext));
            list.add(min);
            
            if (min == twosNext) twoIndex++;
            if (min == threesNext) threeIndex++;
            if (min == fivesNext) fiveIndex++;
        }
        
        return list.get(n - 1);
    }
}