class Solution {
    public int minSwaps(String s) {
        int zero = 0, one = 0;

        for (char c : s.toCharArray()) {
            if (c == '0')
                zero++;
            else
                one++;
        }

        if (Math.abs(zero - one) > 1)
            return -1;

        if (zero > one) {
            return countSwaps(s, '0');
        } else if (one > zero) {
            return countSwaps(s, '1');
        } else {
            return Math.min(countSwaps(s, '0'), countSwaps(s, '1'));
        }
    }

    private int countSwaps(String s, char start) {
        int mismatch = 0;

        for (int i = 0; i < s.length(); i++) {
            char expected;

            if (i % 2 == 0)
                expected = start;
            else
                expected = (start == '0') ? '1' : '0';

            if (s.charAt(i) != expected)
                mismatch++;
        }

        return mismatch / 2;
    }
}