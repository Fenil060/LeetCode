class Solution {
    public int maxFrequency(int[] nums, int k) {
        int max = 1;

        int st = 1;
        int end = nums.length;
        Arrays.sort(nums);

        long[] prefixSum = new long[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (possible(nums, mid, k, prefixSum)) {
                st = mid + 1;
                max = mid;
            } else {
                end = mid - 1;
            }
        }
        return max;
    }

    public boolean possible(int[] nums, int target, int k, long[] prefixSum) {
        for (int right = target - 1; right < nums.length; right++) {
            int left = right - target + 1;

            long windowSum = prefixSum[right + 1] - prefixSum[left];
            long cost = (long) nums[right] * target - windowSum;

            if (cost <= k) {
                return true;
            }
        }
        return false;
    }
}