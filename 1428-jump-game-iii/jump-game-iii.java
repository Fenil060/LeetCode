class Solution {
    public class pair {
        int val;
        int idx;

        public pair(int v, int i) {
            this.val = v;
            this.idx = i;
        }
    }

    public boolean canReach(int[] arr, int start) {
        boolean vis[] = new boolean[arr.length];

        Queue<pair> q = new LinkedList<>();
        q.add(new pair(arr[start], start));

        while (!q.isEmpty()) {
            pair curr = q.poll();
            if (curr.val == 0) {
                return true;
            }

            vis[curr.idx] = true;
            int leftidx = curr.idx - curr.val;
            int rightidx = curr.idx + curr.val;
            if (leftidx >= 0 && leftidx < arr.length && !vis[leftidx]) {
                q.add(new pair(arr[leftidx], leftidx));
            }

            if (rightidx >= 0 && rightidx < arr.length && !vis[rightidx]) {
                q.add(new pair(arr[rightidx], rightidx));
            }
        }
        return false;
    }
}