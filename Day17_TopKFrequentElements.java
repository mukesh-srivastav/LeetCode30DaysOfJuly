import java.util.*;
public class Day17_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(k, (a, b) -> a.getValue() == b.getValue() ? (a.getKey() - b.getKey()) : b.getValue() - a.getValue());
        
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        maxHeap.addAll(map.entrySet());
        
        List<Integer> res = new ArrayList<Integer>();
        
        while (maxHeap.isEmpty() == false && k-- > 0) {
            res.add(maxHeap.poll().getKey()); 
        }
        
        int[] ret = new int[res.size()];
        for (int i=0; i < res.size(); i++)
        {
            ret[i] = res.get(i).intValue();
        }
        return ret;
        
    }
}