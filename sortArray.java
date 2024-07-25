class Solution {
    public void merge(int nums[], int s, int m, int e) {
        int n1 = m - s + 1;
        int n2 = e - m;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        System.arraycopy(nums, s, arr1, 0, n1);
        System.arraycopy(nums, m + 1, arr2, 0, n2);

        int i = 0, j = 0, k = s;

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                nums[k++] = arr1[i++];
            } else {
                nums[k++] = arr2[j++];
            }
        }

        while (i < n1) {
            nums[k++] = arr1[i++];
        }

        while (j < n2) {
            nums[k++] = arr2[j++];
        }
    }

    public void mergeSort(int nums[], int s, int e) {
        if (s < e) {
            int m = s + (e - s) / 2;
            mergeSort(nums, s, m);
            mergeSort(nums, m + 1, e);
            merge(nums, s, m, e);
        }
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}
