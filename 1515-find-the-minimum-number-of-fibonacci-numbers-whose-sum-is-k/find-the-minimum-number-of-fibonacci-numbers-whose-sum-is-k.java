class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);

        while (true) {
            int next = fib.get(fib.size() - 1) + fib.get(fib.size() - 2);
            if (next > k)
                break;
            fib.add(next);
        }

        int count = 0;
        int n = fib.size();
        for (int i = n-1; i >= 0; i--) {
            if (fib.get(i) <= k) {
                count++;
                k -= fib.get(i);
            }
        }
        return count;
    }
}