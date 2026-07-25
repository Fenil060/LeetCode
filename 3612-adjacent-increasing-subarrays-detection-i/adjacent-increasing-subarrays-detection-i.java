class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prev = 0;
        int curr = 1;

        for(int i=1; i<nums.size(); i++){
            if(nums.get(i) > nums.get(i-1)){
                curr++;
            }else{
                if(curr >= 2*k || (prev >= k && curr >= k)){
                    return true;
                }

                prev = curr;
                curr = 1;
            }
        }
    return curr >= 2*k || prev >= k && curr >= k;
    }
}