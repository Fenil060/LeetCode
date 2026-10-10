class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int diff[] = new int[nums1.length];
        int low = 0;
        int high = 0;

        for (int i = 0; i < nums1.length; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            high = Math.max(high, diff[i]);
        }

        long k = k1 + k2;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long required = 0;

            for (int i = 0; i < nums1.length; i++) {
                required += Math.max(0, diff[i] - mid);
            }

            if (required <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long used = 0;

        for (int i = 0; i < diff.length; i++) {
            if (diff[i] > low) {
                used += diff[i] - low;
                diff[i] = low;
            }
        }

        long remaining = k - used;

        for (int i = 0; i < diff.length && remaining > 0  && low > 0; i++) {
            if (diff[i] == low) {
                diff[i]--;
                remaining--;
            }
        }

        long ans = 0;

        for (int d : diff) {
            ans += (long) d * d;
        }

        return ans;

    }
}