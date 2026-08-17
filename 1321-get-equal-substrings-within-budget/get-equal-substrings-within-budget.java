class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int diff[] = new int[n];

        for (int i = 0; i < n; i++) {
            int d = Math.abs(s.charAt(i) - t.charAt(i));
            diff[i] = d;
        }

        int left = 0;
        int maxLen = 0;
        int currCost = 0;
        for (int right = 0; right < n; right++) {
            currCost += diff[right];

            while (currCost > maxCost) {
                currCost -= diff[left];
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}