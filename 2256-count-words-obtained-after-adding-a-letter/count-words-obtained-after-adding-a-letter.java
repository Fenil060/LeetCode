class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {

        HashSet<String> set = new HashSet<>();

        for (String word : startWords) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            set.add(new String(arr));
        }

        int count = 0;

        for (String target : targetWords) {

            char[] a = target.toCharArray();
            Arrays.sort(a);

            for (int i = 0; i < a.length; i++) {
                String candidate = new String(a, 0, i) + new String(a, i + 1, a.length - i - 1); // (arrays, stidx, numOfElement want to add)

                if (set.contains(candidate)) {
                    count++;
                    break;
                }
            }

        }
        return count;
    }
}