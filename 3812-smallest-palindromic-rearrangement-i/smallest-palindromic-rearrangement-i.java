class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();

        char arr[] = new char[n];

        int st = 0;
        int end = n - 1;
        int mid = n / 2;

        int count[] = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            while (count[i] >= 2) {
                arr[st] = (char) ('a' + i);
                arr[end] = (char) ('a' + i);
                st++;
                end--;
                count[i] -= 2;
            }
            if (count[i] == 1) {
                arr[mid] = (char) ('a' + i);
            }
        }
        return new String(arr);
    }
}