/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

Solution:

The idea is to pick each element one by one from the input set, then generate subset for the same and we follow this process recursively.
We’ll use ArrayList for this purpose
For ex,
f(0) = {a}, {} // {} when we don’t include any element from the set, it is null i.e {}.
f(1) = {a}, {}, {b}, {a, b} // We have to copy all the elements from f(0) and then include the very next element from the set i.e b. So f(1) = f(0) + 1;
f(2) = {a}, {}, {b}, {a, b}, {a, c}, {c}, {b, c}, {a, b, c} .So f(2) = f(1) +2;

The general form becomes f(n) = f(n-1) + n;
 */
import java.util.*;
public class Day11_GenerateAllSubsets {
    public List<List<Integer>> subsets(int[] nums) {
        return getSubset(nums, nums.length - 1);
    }
    
    List<List<Integer>> getSubset(int nums[], int index)
    {
        List<List<Integer>> allSubsets;
        
        if (index < 0) {
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<Integer>());
        } else {
            allSubsets = getSubset(nums, index - 1);
            int item = nums[index];
            List<List<Integer>> moreSubsets = new ArrayList<>();
            
            for (List<Integer> subset : allSubsets) {
                List<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }
        
        return allSubsets;
    }
}