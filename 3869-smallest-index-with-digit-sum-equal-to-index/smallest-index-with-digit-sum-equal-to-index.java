class Solution {
    public int smallestIndex(int[] nums) {

        for(int i=0; i<nums.length; i++){
            int sumofdig = sum(nums[i]);
            if(sumofdig == i){
                return i;
            }
        }
    return -1;
    }

    public int sum(int n){
        int s = 0;

        while(n > 0){
            s += n % 10;
            n /= 10;
        }
    return s;
    }
}