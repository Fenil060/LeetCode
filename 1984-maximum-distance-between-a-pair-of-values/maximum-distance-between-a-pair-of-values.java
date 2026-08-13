class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int l = 0;
        int r = 0;
        int max = 0;
        while(l < nums1.length && r < nums2.length){
            if(l <= r && nums1[l] <= nums2[r]){
                max = Math.max(max, r-l);
                r++;
            }else if(l > r){
                while(r != l){
                    r++;
                }
            }else{
                // if(nums1[l] > nums2[r]){
                    l++;
                // }
            }
        }
    return max;
    }
}