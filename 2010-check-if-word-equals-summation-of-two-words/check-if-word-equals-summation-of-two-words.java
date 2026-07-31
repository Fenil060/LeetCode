class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        for (char c : firstWord.toCharArray()) {
            int dig = c - 'a';
            num1 = num1 * 10 + dig;
        }

        for (char c : secondWord.toCharArray()) {
            int dig = c - 'a';
            num2 = num2 * 10 + dig;
        }

        for (char c : targetWord.toCharArray()) {
            int dig = c - 'a';
            num3 = num3 * 10 + dig;
        }
        return (num1 + num2) == num3;
    }
}