class Solution {
    public int maxProduct(int n) {
        String s = String.valueOf(n);
        int size = s.length();

        int arr[] = new int[10];
        for(char c : s.toCharArray()){
            int dig = c - '0';
            arr[dig]++;
        }

        int product = 1;
        int count = 0;

        for(int i=arr.length-1; i>=0; i--){
            while(arr[i] != 0 && count < 2){
                product *= i;
                count++;
                arr[i]--;
            }
        }
    return product;
    }
}