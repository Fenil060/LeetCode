class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];
        for (int i = 0; i < nums.length; i++) {
            long newDp[] = new long[k];

            // 1. Start a new subarray with nums[i]
            int rem = nums[i] % k;
            newDp[rem]++;

            // 2. Extend all previous subarrays
            for (int r = 0; r < k; r++) {
                if (dp[r] == 0) {
                    continue;
                }

                int newRem = (int) ((long) r * nums[i] % k);
                newDp[newRem] += dp[r];
            }

            // 3. Add current subarrays to answer
            for (int r = 0; r < k; r++) {
                result[r] += newDp[r];
            }

            // 4. Current becomes previous
            dp = newDp;
        }
        return result;
    }
}