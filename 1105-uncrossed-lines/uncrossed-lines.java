class Solution {
    int dp[][];

    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        dp = new int[nums1.length][nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, nums1, nums2);
    }

    public int solve(int i, int j, int[] nums1, int[] nums2) {
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        if (nums1[i] == nums2[j]) {
            return dp[i][j] = 1 + solve(i + 1, j + 1, nums1, nums2);
        } else {
            return dp[i][j] = Math.max(solve(i + 1, j, nums1, nums2), solve(i, j + 1, nums1, nums2));
        }
    }
}