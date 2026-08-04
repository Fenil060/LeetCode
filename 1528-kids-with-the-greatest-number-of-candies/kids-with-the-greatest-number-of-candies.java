class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int c : candies) {
            max = Math.max(max, c);
        }

        List<Boolean> ans = new ArrayList<>();
        for (int c : candies) {
            if (c + extraCandies >= max) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}