class Solution {
    public int minimumDeletions(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIdx = 0;
        int maxIdx = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }

        int bothFront = Math.max(minIdx + 1, maxIdx + 1);
        int bothBack = Math.max(n - maxIdx, n - minIdx);

        int oneFrontOneBack = Math.min(minIdx, maxIdx) + 1 + n - Math.max(minIdx, maxIdx);
        return Math.min(oneFrontOneBack, Math.min(bothFront, bothBack));
    }
}