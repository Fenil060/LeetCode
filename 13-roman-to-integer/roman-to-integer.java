class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int count = 0;
        int i = 0;
        while (i < s.length()) {

            if (i + 1 < s.length()) {
                String sub = s.substring(i, i + 2);

                if (map.containsKey(sub)) {
                    count += map.get(sub);
                    i += 2;
                    continue;
                }
            }

            count += map.get(String.valueOf(s.charAt(i)));
            i++;

        }
        return count;
    }
}