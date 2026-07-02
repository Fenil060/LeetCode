class Solution {
    public String countAndSay(int n) {
        // Base case
        if (n == 1)
            return "1";

        // Get previous string
        String prev = countAndSay(n - 1);

        // Build current string using RLE
        StringBuilder ans = new StringBuilder();

        int count = 1;

        for (int i = 1; i <= prev.length(); i++) {

            if (i < prev.length() && prev.charAt(i) == prev.charAt(i - 1)) {
                count++;
            } else {
                ans.append(count);
                ans.append(prev.charAt(i - 1));
                count = 1;
            }
        }

        return ans.toString();
    }
}