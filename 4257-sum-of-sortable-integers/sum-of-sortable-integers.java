class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;
            int prevLast = -1;

            for (int st = 0; st < n; st += k) {
                int minIdx = st;
                int maxIdx = st;

                for (int i = st + 1; i < st + k; i++) {
                    if (nums[i] < nums[minIdx]) {
                        minIdx = i;
                    }
                    if (nums[i] > nums[maxIdx]) {
                        maxIdx = i;
                    }
                }

                int drops = 0;

                for (int i = st; i < st + k; i++) {
                    int next = st + (i - st + 1) % k;

                    if (nums[i] > nums[next]) {
                        drops++;
                    }
                }

                if (drops > 1) {
                    valid = false;
                    break;
                }

                int first = nums[minIdx];
                int last = nums[maxIdx];

                if (st > 0 && prevLast > first) {
                    valid = false;
                    break;
                }

                prevLast = last;
            }

            if (valid) {
                sum += k;
            }
        }

        return sum;
    }
}