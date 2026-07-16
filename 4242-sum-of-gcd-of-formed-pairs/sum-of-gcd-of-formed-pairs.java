class Solution {
    public long gcdSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        int arr[] = new int[n];
    
        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
            arr[i] = gcd(nums[i], max);
        }

        Arrays.sort(arr);

        long sum = 0;

        for(int i=0; i<n/2; i++){
            sum += gcd(arr[i], arr[n-i-1]);
        }
    return sum;
    }

    public int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
    return a;
    }
}