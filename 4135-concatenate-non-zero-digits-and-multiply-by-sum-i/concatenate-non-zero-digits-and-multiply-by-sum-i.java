class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long x = 0;
        long pow = 1;

        while (n > 0) {
            long dig = n % 10;
            n = n / 10;
            if (dig != 0) {
                sum += dig;
                x = x + dig * pow;
                pow *= 10;
            }
        }
        return sum * x;
    }
}