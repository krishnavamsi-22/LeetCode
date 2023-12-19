class Solution {
    private int firstOcc(int[] nums, int target) {
        int n = nums.length, low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] != nums[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    private int lastOcc(int[] nums, int target) {
        int n = nums.length, low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == n - 1 || nums[mid + 1] != nums[mid]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{firstOcc(nums, target), lastOcc(nums, target)};
    }

}
