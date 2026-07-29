class Solution {
    public long countPairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            char c = word.charAt(0);
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i);
                int diff = (curr - c + 26) % 26;
                sb.append(diff + "#");
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }

        long count = 0;
        for (String key : map.keySet()) {
            int len = map.get(key);
            count += (long) len * (len - 1) / 2;
        }
        return count;
    }
}