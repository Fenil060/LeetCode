class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                openStack.push(i);
            }else if(c == '*'){
                starStack.push(i);
            }else{ // c == ')'
                if(!openStack.isEmpty()){
                    openStack.pop();
                }else if(!starStack.isEmpty()){
                    starStack.pop();
                }else{
                    return false;
                }
            }
        }

        // Match remaining '(' with '*'
        while(!openStack.isEmpty() && !starStack.isEmpty()){
            if(openStack.peek() < starStack.peek()){
                openStack.pop();
                starStack.pop();
            } else {
                return false;
            }
        }

    return openStack.isEmpty();
    }
}