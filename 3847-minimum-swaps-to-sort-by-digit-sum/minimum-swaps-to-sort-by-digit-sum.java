import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // 1. Create a 2D array to map [digitSum, originalValue]
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = getDigitSum(nums[i]);
            pair[i][1] = nums[i];
        }
        
        // 2. Sort based on custom rule: digit sum first, then number value
        Arrays.sort(pair, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        // 3. Map each number to its target index in the sorted order
        Map<Integer, Integer> targetPos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            targetPos.put(pair[i][1], i);
        }
        
        // 4. Find the minimum swaps using permutation cycle decomposition
        boolean[] visited = new boolean[n];
        int totalSwaps = 0;
        
        for (int i = 0; i < n; i++) {
            // Skip if already visited or already at its correct target index
            if (visited[i] || targetPos.get(nums[i]) == i) {
                continue;
            }
            
            // Traverse the cycle and find its size
            int cycleSize = 0;
            int curr = i;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = targetPos.get(nums[curr]); // Jump to where the current element belongs
                cycleSize++;
            }
            
            // A cycle of size k requires (k - 1) swaps
            if (cycleSize > 0) {
                totalSwaps += (cycleSize - 1);
            }
        }
        
        return totalSwaps;
    }
    
    // Helper function to calculate the sum of digits
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
