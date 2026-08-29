class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        int arr[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int st = 0;

        while (st < n) {
            int end = st;

            while (end + 1 < n && arr[end + 1][0] - arr[end][0] <= limit) {
                end++;
            }

            List<Integer> values = new ArrayList<>();
            List<Integer> indices = new ArrayList<>();

            for (int i = st; i <= end; i++) {
                values.add(arr[i][0]);
                indices.add(arr[i][1]);
            }

            Collections.sort(indices);
           
            for (int i = 0; i < values.size(); i++) {
                nums[indices.get(i)] = values.get(i);
            }

            st = end + 1;
        }
        return nums;
    }
}