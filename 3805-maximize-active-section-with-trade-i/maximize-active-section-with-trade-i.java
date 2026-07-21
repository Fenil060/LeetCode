class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1')
                ones++;
        }

        String t = "1" + s + "1";

        ArrayList<Integer> len = new ArrayList<>();
        ArrayList<Character> type = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {
            int count = 0;
            char curr = s.charAt(i);

            while (i < s.length() && curr == s.charAt(i)) {
                count++;
                i++;
            }

            len.add(count);
            type.add(curr);
        }

        int maxCount = 0;
        for(int j=1; j<len.size()-1; j++){
            if(type.get(j-1) == '0' && type.get(j) == '1' && type.get(j+1) == '0'){
                int currCount = len.get(j-1) + len.get(j+1);
                maxCount = Math.max(maxCount, currCount);
            }
        }
    return maxCount + ones;
    }
}