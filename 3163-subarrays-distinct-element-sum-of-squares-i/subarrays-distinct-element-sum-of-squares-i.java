import java.util.List;
import java.util.HashSet;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int totalSum = 0;
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            HashSet<Integer> distinctElements = new HashSet<>();
  
            for (int j = i; j < n; j++) {
                distinctElements.add(nums.get(j));
                
 
                int distinctCount = distinctElements.size();
                
                
                totalSum += distinctCount * distinctCount;
            }
        }
        
        return totalSum;
    }
}
