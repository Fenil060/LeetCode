class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> ans = new ArrayList<>();

        int arr[] = new int[upper + 1];
        Arrays.fill(arr, -1);
        for (int num : nums) {
            if(lower <= num && num <= upper){
                arr[num] = 1;
            }
        }
        int st = lower;
        int end = lower;

        while (st <= upper) {
            while (st <= upper && arr[st] != -1) {
                st++;
            }
            if(st > upper){
                break;
            }
            end = st;
            while (end <= upper && arr[end] == -1) {
                end++;
            }
            
            ans.add(new ArrayList<>(Arrays.asList(st, end-1)));
            st = end;
        }
        return ans;
    }
}