class Solution {
    public int[] twoSum(int[] nums, int target) {
     
      HashMap<Integer,Integer> hm = new HashMap<>();
       for(int i=0; i<nums.length; i++) {
        int num = nums[i];
        int moreNeed = target - nums[i];

        if(hm.containsKey(moreNeed)) {
            return new int[] {hm.get(moreNeed), i};
        }

        hm.put(nums[i], i);
       }
       return new int[]{-1,-1};
    }
}