
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int minIdx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                minIdx = i;
                break;
            }
        }

        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < n; i++) {
            if (nums[(minIdx + i) % n] != i) {
                increasing = false;
            }

            if (nums[(minIdx - i + n) % n] != i) {
                decreasing = false;
            }
        }

        int ans = Integer.MAX_VALUE;
        if (increasing) {
            ans = Math.min(ans, Math.min(minIdx, n - minIdx + 2));
        }

        if (decreasing) {
            ans = Math.min(ans, Math.min(minIdx + 2, n - minIdx));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
