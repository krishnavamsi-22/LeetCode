class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int quarter = n / 4;

        for (int i = 0; i < n - quarter; i++) {
            int target = arr[i];
            int start = i;
            int end = i + quarter;

            // Use binary search to find the first occurrence of the target
            while (start < end) {
                int mid = start + (end - start) / 2;

                if (arr[mid] == target) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            // Check if the target occurs more than 25% of the time
            if (arr[start] == target && start + quarter < n && arr[start + quarter] == target) {
                return target;
            }
        }

        return -1;
    }
}
