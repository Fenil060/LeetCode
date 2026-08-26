class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String str = "";

        int left = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1') {
                count++;
            }

            while (count > k) {
                if (s.charAt(left) == '1') {
                    count--;
                }
                left++;
            }

            if (count == k) {
                while (s.charAt(left) == '0') {
                    left++;
                }

                String curr = s.substring(left, right + 1);

                if (str.equals("") || curr.length() < str.length() || (curr.length() == str.length() && curr.compareTo(str) < 0)) {
                    str = curr;
                }
            }
        }

        return str;
    }
}