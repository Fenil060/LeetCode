class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        int count = 0;

        int idx = 0;

        while(idx < nums.length ){
            int min = nums[idx];

            while(idx < nums.length && nums[idx]-min <= k){
                idx++;
            }
            count++;

        }
    return count;
    }
}