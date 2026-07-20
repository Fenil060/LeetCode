class Solution {
    public void sortColors(int[] nums) {
        
        int st = 0;
        int mid = 0;
        int end = nums.length-1;

        while(mid <= end) {
            if(nums[mid]==0) {
                int temp = nums[st];
                nums[st] = nums[mid];
                nums[mid] = temp;
                mid++;
                st++;
            }else if(nums[mid]==1) {
                mid++;
            }else {
                int temp = nums[mid];
                nums[mid] = nums[end];
                nums[end] = temp;
                end--;
            }
        }
    }
}