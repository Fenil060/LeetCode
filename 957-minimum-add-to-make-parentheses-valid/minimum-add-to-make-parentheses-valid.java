class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(ch);
            }else{ //ch == ')'
                if(st.isEmpty()){
                    count++;
                }else{
                    st.pop();
                }
            }
        }

        if(!st.isEmpty()){
            count += st.size();
        }
    return count;
    }
}