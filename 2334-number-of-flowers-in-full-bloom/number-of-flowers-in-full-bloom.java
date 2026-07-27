class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;

        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int[] ans = new int[people.length];

        for (int i = 0; i < people.length; i++) {
            int started = upperBound(starts, people[i]); // start <= person
            int ended = lowerBound(ends, people[i]); // end < person

            ans[i] = started - ended;
        }

        return ans;
    }

    // First index with value > target
    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }

    // First index with value >= target
    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }
}