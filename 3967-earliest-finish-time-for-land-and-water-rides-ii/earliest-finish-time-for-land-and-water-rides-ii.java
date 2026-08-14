class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        // Land -> Water
        ans = Math.min(ans, solve(landStartTime, landDuration, waterStartTime, waterDuration));

        // Water -> Land
        ans = Math.min(ans, solve(waterStartTime, waterDuration, landStartTime, landDuration));

        return ans;
    }

    public int solve(int[] firstStart, int[] firstDuration, int[] secondStart, int[] secondDuration) {

        int n = secondStart.length;

        // Store (start, duration) together
        int[][] rides = new int[n][2];

        for (int i = 0; i < n; i++) {
            rides[i][0] = secondStart[i];
            rides[i][1] = secondDuration[i];
        }

        // Sort according to start time
        Arrays.sort(rides, (a, b) -> Integer.compare(a[0], b[0]));

        int[] start = new int[n];
        int[] duration = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = rides[i][0];
            duration[i] = rides[i][1];
        }

        // Prefix minimum duration
        int[] prefixMin = new int[n];
        prefixMin[0] = duration[0];

        for (int i = 1; i < n; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], duration[i]);
        }

        // Suffix minimum of (start + duration)
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = start[n - 1] + duration[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min( suffixMin[i + 1], start[i] + duration[i] );
        }

        int ans = Integer.MAX_VALUE;

        // Choose every first ride
        for (int i = 0; i < firstStart.length; i++) {

            int firstFinish = firstStart[i] + firstDuration[i];

            // Number of second rides with start <= firstFinish
            int idx = upperBound(start, firstFinish);

            // Second ride is already open
            if (idx > 0) {
                ans = Math.min(ans,firstFinish + prefixMin[idx - 1]);
            }

            // Second ride is not open yet
            if (idx < n) {
                ans = Math.min(ans,suffixMin[idx]);
            }
        }

        return ans;
    }

    // Returns number of elements <= target
    public int upperBound(int[] arr, int target) {

        int left = 0;
        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}