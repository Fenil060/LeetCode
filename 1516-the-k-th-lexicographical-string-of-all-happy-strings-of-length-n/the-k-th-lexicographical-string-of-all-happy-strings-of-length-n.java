class Solution {
    public String getHappyString(int n, int k) {
        List<String> li = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String s = "abc";
        solve(n, 0, li, sb, s, 'z');

        Collections.sort(li);
        if (li.size() < k) {
            return "";
        }
        return li.get(k - 1);
    }

    public void solve(int n, int idx, List<String> li, StringBuilder sb, String s, char lastChar) {
        if (idx == n) {
            if (sb.length() == n) {
                li.add(sb.toString());
                return;
            } else {
                return;
            }
        }

        for (int i = 0; i < 3; i++) {
            char nextChar = s.charAt(i);
            if (nextChar != lastChar) {
                solve(n, idx + 1, li, sb.append(nextChar), s, nextChar);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}