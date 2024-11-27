import java.util.Arrays;

 class Solution {
    public static void main(String[] args) {
        // Example array to be sorted
        int[] nums = {5, 2, 3, 1};

        // Print the array before sorting
        System.out.println("Before Sorting: " + Arrays.toString(nums));

        // Sort the array using the sortArray method
        nums = sortArray(nums);

        // Print the sorted array
        System.out.println("After Sorting: " + Arrays.toString(nums));
    }

    public static int[] sortArray(int[] nums) {
        // Invoke the mergeSort function with appropriate attribute values
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mergeSort(int[] array, int low, int high) {
        // Calculate the mid index and invoke the mergeSort function recursively
        if (low < high) {
            int mid = low + (high - low) / 2;

            // Recursively sort the left and right halves
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);

            // Merge the sorted arrays
            merge(array, low, mid, high);
        }
    }

    public static void merge(int[] array, int low, int mid, int high) {
        // Create two temporary arrays for holding the left and right subarrays
        int leftSize = mid - low + 1;
        int rightSize = high - mid;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        // Copy elements into the left and right subarrays
        for (int i = 0; i < leftSize; i++) {
            left[i] = array[low + i];
        }
        for (int j = 0; j < rightSize; j++) {
            right[j] = array[mid + 1 + j];
        }

        // Merge the two sorted subarrays into the original array
        int i = 0, j = 0, k = low; // Pointers for left, right, and merged array

        // Compare elements from both subarrays and merge them into the original array
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left subarray
        while (i < leftSize) {
            array[k] = left[i];
            i++;
            k++;
        }

        // Copy any remaining elements from the right subarray
        while (j < rightSize) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
}
