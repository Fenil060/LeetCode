class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int knownSum = 0;

        for(int num : rolls){
            knownSum += num;
        }

        int totalLen = m+n;
        int totalSum = (m+n) * mean;
        int missingSum = totalSum - knownSum;

        if(missingSum < n || missingSum > 6*n){
            return new int[0];
        }

        int []ans = new int[n];

        for(int i=0; i<n; i++){
            ans[i] = missingSum / n;
        }

        int remaining = missingSum % n;

        for(int i=0; i<remaining; i++){
            ans[i]++;
        }
        return ans;
    }
}