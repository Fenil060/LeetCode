class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for(int s : stones){
            totalSum += s;
        }

        int target = totalSum / 2;

        int [][]dp = new int[stones.length][target+1];
        for(int []d : dp){
            Arrays.fill(d, -1);
        }

    return solve(0, 0, totalSum, stones, target, dp);
    }

    public int solve(int idx, int currSum, int totalSum, int []stones, int target, int[][] dp){
        if(idx == stones.length){
            return totalSum - 2*currSum;
        }

        if(dp[idx][currSum] != -1){
            return dp[idx][currSum];
        }
        int take = Integer.MAX_VALUE;
        if(currSum + stones[idx] <= target){
            take = solve(idx+1, currSum+stones[idx], totalSum, stones, target, dp);
        }

        int skip = solve(idx+1, currSum, totalSum, stones, target, dp);

        return dp[idx][currSum] = Math.min(take, skip);
    }
}