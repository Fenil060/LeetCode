class Solution {
    int minRemoved = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {
        Set<String> ans = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        generate(0, 0, 0, s, sb, ans);
        return new ArrayList<>(ans);
    }

    public void generate(int idx, int count, int removed, String s, StringBuilder sb, Set<String> ans) {

        if (count < 0) {
            return;
        }

        if (idx == s.length()) {
            if (count == 0) {
                if (removed < minRemoved) {
                    minRemoved = removed;
                    ans.clear();
                    ans.add(sb.toString());
                } else if(removed == minRemoved){
                    ans.add(sb.toString());
                }
            }
            return;
        }

        char ch = s.charAt(idx);

        if (ch >= 'a' && ch <= 'z') {
            sb.append(ch);
            generate(idx + 1, count, removed, s, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        } else if (ch == '(') {
            //take
            sb.append(ch);
            generate(idx + 1, count + 1, removed, s, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
            //not take
            generate(idx + 1, count, removed + 1, s, sb, ans);

        } else {
            //take
            if (count > 0) {
                sb.append(ch);
                generate(idx + 1, count - 1, removed, s, sb, ans);
                sb.deleteCharAt(sb.length() - 1);
            }

            //not take
            generate(idx + 1, count, removed + 1, s, sb, ans);

        }

    }
}