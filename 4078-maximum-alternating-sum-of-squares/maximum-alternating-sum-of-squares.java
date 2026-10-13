class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long totalSum = 0;

        for(int i=0; i<n; i++){
            nums[i] = nums[i] * nums[i];
            totalSum += nums[i];

        }

        Arrays.sort(nums);

        long sum1 = 0;
       

        for(int i=0; i<n/2; i++){
            sum1 += nums[i];
        }

        return totalSum - (sum1*2);
    }
}