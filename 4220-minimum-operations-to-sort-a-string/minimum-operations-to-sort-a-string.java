class Solution {
    public int minOperations(String s) {
        char minChar = 'z';
        char maxChar = 'a';

        for (char c : s.toCharArray()) {
            if (c < minChar) {
                minChar = c;
            } 
            if (c > maxChar) {
                maxChar = c;
            }
        }

        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);

        //case1 : Already sorted
        if (s.equals(sorted)) {
            return 0;
        } else if (s.length() == 2) { //case2 : length = 2
            return -1;
        } else if (minChar == s.charAt(0) || maxChar == s.charAt(s.length() - 1)) {
            return 1;
        }
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == minChar || s.charAt(i) == maxChar) {
                return 2;
            }
        }
    return 3;
    }
}