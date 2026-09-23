class Solution {
    public int minOperations(int[] nums, int x) {
        int totalsum = 0;
        int ans = Integer.MAX_VALUE;
        for (int n : nums) {
            totalsum += n;
        }

        int targetSum = totalsum - x;
        if (targetSum < 0) {
            return -1;
        }

        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum > targetSum) {
                sum -= nums[left];
                left++;
            }

            if (sum == targetSum) {
                ans = Math.min(ans, nums.length - (right - left + 1));
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}