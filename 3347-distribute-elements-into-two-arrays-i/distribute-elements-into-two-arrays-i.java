class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        List<Integer> li1 = new ArrayList<>();
        List<Integer> li2 = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(li1.size() == 0){
                li1.add(nums[i]);
            }else if(li2.size() == 0){
                li2.add(nums[i]);
            }else{
                if(li1.get(li1.size()-1) > li2.get(li2.size()-1)){
                    li1.add(nums[i]);
                }else{
                    li2.add(nums[i]);
                }
            }
        }

        for(int i=0; i<li2.size(); i++){
            li1.add(li2.get(i));
        }

        int ans[] = new int[li1.size()];
        for(int i=0; i<n; i++){
            ans[i] = li1.get(i);
        }
        return ans;
    }
}