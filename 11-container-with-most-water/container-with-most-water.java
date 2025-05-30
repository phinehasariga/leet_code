class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            
            int width = right - left;
            int currentArea = width * Math.min(height[left], height[right]);
            
            
            maxArea = Math.max(maxArea, currentArea);
            
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}