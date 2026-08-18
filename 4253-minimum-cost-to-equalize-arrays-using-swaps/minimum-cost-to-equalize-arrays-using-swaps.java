class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
            map.put(nums2[i], map.getOrDefault(nums2[i], 0)-1);
        }

        int op = 0;

        for(int key : map.keySet()){
            int diff = map.get(key);

            if(diff % 2 != 0){
                return -1;
            }

            op += Math.abs(diff)/2;
        }
    return op/2;
    }
}