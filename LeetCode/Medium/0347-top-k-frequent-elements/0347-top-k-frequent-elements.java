import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            int value = map.get(num) == null ? 0 : map.get(num);
            value++;
            map.put(num, value);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, (v1, v2) -> (map.get(v2).compareTo(map.get(v1)))); 
        
        for(int i = 0; i < k; i++) {
            result[i] = keySet.get(i);
		}
        
        return result;
    }
}