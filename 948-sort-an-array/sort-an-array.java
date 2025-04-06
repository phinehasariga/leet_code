class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums; // Return empty or single-element array
        }
        mergeSort(nums, 0, nums.length - 1); // Call the recursive Merge Sort
        return nums; // Return the sorted array
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2; // Find the middle point
            mergeSort(nums, low, mid); // Sort the left half
            mergeSort(nums, mid + 1, high); // Sort the right half
            merge(nums, low, mid, high); // Merge the two sorted halves
        }
    }

    private void merge(int[] nums, int low, int mid, int high) {
        // Create temporary arrays for the left and right halves
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            left[i] = nums[low + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = nums[mid + 1 + j];
        }

        // Merge the two arrays
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                nums[k] = left[i];
                i++;
            } else {
                nums[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left[] (if any)
        while (i < n1) {
            nums[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements of right[] (if any)
        while (j < n2) {
            nums[k] = right[j];
            j++;
            k++;
        }
    }
}
        
