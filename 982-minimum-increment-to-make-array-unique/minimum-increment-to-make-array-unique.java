class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int count = 0;
        int next = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < next) {
                count += next - nums[i];
                next++;
            } else {
                next = nums[i] + 1;
            }
        }
        return count;
    }
}