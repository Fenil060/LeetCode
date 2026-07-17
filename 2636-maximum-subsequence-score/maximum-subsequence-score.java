class Solution {
   
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        int [][]pairs = new int[n][2];

        for(int i=0; i<n; i++){
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        }

        Arrays.sort(pairs, (a,b) -> b[0] - a[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long ans = 0;

        for(int i=0; i<n; i++){
            pq.offer(pairs[i][1]);
            sum += pairs[i][1];

            if(pq.size() > k){
                sum -= pq.poll();
            }

            if(pq.size() == k){
                ans = Math.max(ans, sum*pairs[i][0]);
            }
        }
    return ans;
    }

    
}


// public void solve(int idx, int count, long sum, int min, int k, int[] nums1, int[] nums2) {
//         if (count == k) {
//             ans = Math.max(ans, sum * min);
//             return;
//         }

//         if (idx == nums1.length) {
//             return;
//         }

//         solve(idx + 1, count + 1, sum + nums1[idx], Math.min(min, nums2[idx]), k, nums1, nums2);
//         solve(idx + 1, count, sum, min, k, nums1, nums2);
//     }