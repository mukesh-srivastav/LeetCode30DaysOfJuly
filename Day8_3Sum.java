import java.util.*;
public class Day8_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        if (n<3)
            return (new ArrayList<>(res));
        
        Arrays.sort(nums);
        for (int i=0; i<n-2; i++) {
            int low = i+1;
            int high = n -1;
            int k = nums[i];
            
            while (low < high) {
                if (nums[low] + nums[high] + k == 0) {
                    res.add(Arrays.asList(k, nums[low], nums[high]));
                    low++;
                    high--;
                } else if (nums[low] + nums[high] + k < 0)
                    low++;
                else
                    high--;
            }
            
        }
        
        return (new ArrayList<>(res));
    }   
}