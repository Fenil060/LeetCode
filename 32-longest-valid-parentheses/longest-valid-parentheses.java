class Solution {
    public int longestValidParentheses(String s) {
        Stack<Object> st = new Stack<>();

        int max = 0;

        for (char ch : s.toCharArray()) {
            //case1 : opening parenthesis
            if (ch == '(') {
                st.push(ch);
            } else { //closing parenthesis
                     //case1: stack is empty
                if (st.isEmpty()) {
                    continue;
                } else if (st.peek() instanceof Character) { //case-2 peek is opening parenthesis
                    st.pop();
                    int len = 2;

                    if (!st.isEmpty() && st.peek() instanceof Integer) { // check if peek having digit the sum up with len
                        len += (int)st.pop();
                    }
                    st.push(len);
                    max = Math.max(len, max);
                } else { // ( 3 ) like this case
                    int len = (int) st.pop();

                    if (!st.isEmpty() && st.peek() instanceof Character) {
                        st.pop();
                        len += 2;

                        if (!st.isEmpty() && st.peek() instanceof Integer) { // check if peek having digit the sum up with len
                            len += (int) st.pop();
                        }
                        st.push(len);
                        max = Math.max(max, len);
                    }
                }
            }
           
        }
         return max;
    }
}