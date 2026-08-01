class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {

        int n = monsters.length;
        long diff[] = new long[n + 1];

        for (int[] b : boosts) {
            int s = b[0];
            int e = b[1];
            int c = b[2];
            diff[s] += c;
            if (e + 1 < n) {
                diff[e + 1] -= c;
            }
        }

        long bonus[] = new long[n];
        bonus[0] = diff[0];
        for (int i = 1; i < n; i++) {
            bonus[i] = bonus[i - 1] + diff[i];
        }

        long st = Math.max(0L, (long) monsters[0] - bonus[0]);
        long end = 0;
        for (int x : monsters) {
            end += x;
        }

        while (st <= end) {
            long mid = st + (end - st) / 2;

            if (possible(mid, monsters, bonus)) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }

    public boolean possible(long curr, int[] m, long[] b) {

        for (int i = 0; i < m.length; i++) {
            if (b[i] + curr < m[i]) {
                return false;
            }

            curr -= m[i];
            if (curr < 0) {
                curr = 0;
            }
        }
        return true;
    }
}