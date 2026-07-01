class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        if (n == 0) {
            return 0;
        }

        for (int j = 0; j <= haystack.length() - n; j++) {
            String ans = haystack.substring(j, j + n);
            if (ans.equals(needle)) {
                return j;
            }
        }
        return -1;
    }
}