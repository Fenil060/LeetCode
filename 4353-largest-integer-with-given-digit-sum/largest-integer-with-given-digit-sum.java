class Solution {
    public int largestInteger(int n, int s) {
        if(s > 9*n) return -1;

        int sum = 0;
        int pow = 1;
        while(n > 0){
            if(s >= 9 ){
                sum = sum *10 + 9;
                s -= 9;
                // pow *= 10;
                n--;
            }else{
                sum = sum*10 + s;
                // pow *= 10;
                s -= s;
                n--;
            }
        }
    return sum;
    }
}