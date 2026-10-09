class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();

        int count = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(s.charAt(i));
            }else{ // c == ')'
                //case1 : st is Empty
                if(st.isEmpty()){
                    if(i+1 < s.length() && s.charAt(i+1) == ')'){
                        count++;
                        i++;
                    }else{
                        count += 2;
                    }
                }else if(i+1 < s.length() && s.charAt(i+1) == ')'){
                    st.pop();
                    i++;
                }else{ // next is not ')'
                    st.pop();
                    count++;
                }
            }
        }

       
        count += 2*st.size();
        
    return count;
    }
}