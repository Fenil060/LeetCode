class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        int n = s.length();
        long MOD = 1000000007L;
        long[] pos = new long[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R')
                pos[i] = (long) nums[i] + d;
            else
                pos[i] = (long) nums[i] - d;
        }

        Arrays.sort(pos);

        long ans = 0;
        long prefixSum = 0;

        for (int i = 0; i < n; i++) {
            ans = (ans + (pos[i] * i - prefixSum)) % MOD;
            prefixSum += pos[i];
        }

        return (int) ans;
    }
}