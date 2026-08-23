class Solution {
    public int longestSubarray(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        int n = nums.length;

        int left = 0;
        for (int right = 0; right < n; right++) {
            List<Integer> prime = getFactors(nums[right]);

            for (int p : prime) {
                map.put(p, map.getOrDefault(p, 0) + 1);
            }

            while (map.size() > k) {
                List<Integer> leftPrime = getFactors(nums[left]);
                for (int p : leftPrime) {
                    map.put(p, map.get(p) - 1);

                    if (map.get(p) == 0) {
                        map.remove(p);
                    }
                }

                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public List<Integer> getFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int p = 2; p * p <= num; p++) {
            if (num % p == 0) {
                factors.add(p);
            }

            while (num % p == 0) {
                num /= p;
            }
        }
        if (num > 1) {
            factors.add(num);
        }
        return factors;
    }
}