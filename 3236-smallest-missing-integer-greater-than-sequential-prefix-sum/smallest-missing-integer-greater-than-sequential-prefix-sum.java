class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }

        int left = 0;
        int sum = nums[left];
        int max = sum;

        for(int right=1; right<nums.length; right++){
            if(nums[right] == nums[right-1]+1){
                sum += nums[right];
                max = Math.max(max, sum);
            }else{
                while(left <= right){
                    sum -= nums[left];
                    left++;
                }
            }
        }

        while(set.contains(max)){
            max++;
        }
    return max;
    }
}