class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Object> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(ch);
            }else{
                if(st.peek() instanceof Character){
                    st.pop();
                    st.push(1);
                }else{
                    int score = 0;
                    while(!st.isEmpty() && st.peek() instanceof Integer){
                        score += (int) st.pop();
                    }

                    st.pop();

                    st.push(2*score);

                }
            }
        }

        int ans = 0;

        while(!st.isEmpty()){
            ans += (int) st.pop();
        }
    return ans;
    }
}