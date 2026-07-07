class Solution {
    public boolean isPalindrome(int x) {
        int ans=0;
        int original = x;
        if(x<0){
            return false;
        }
        while(x>0){
            ans = ans*10 + x%10;
            x /= 10; 
        }
        return ans==original;
    }
}