class Solution {
    List<String> li = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        generate(sb, n, n);
        return li;
    }

    public void generate(StringBuilder sb, int rem1, int rem2){
        if(rem1 == 0 && rem2 == 0){
            li.add(sb.toString());
            return;
        }

        if(rem1 > 0){
            generate(sb.append("("), rem1-1, rem2);
            sb.deleteCharAt(sb.length()-1);
        }

        if(rem2 > rem1){
            generate(sb.append(")"), rem1, rem2-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}