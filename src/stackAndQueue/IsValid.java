package stackAndQueue;

import java.util.Stack;

public class IsValid {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else if(!stack.isEmpty() && paired(stack.peek(),c)){
                stack.pop();
            }
            else
                return false;
        }
        return stack.isEmpty();
    }
    private boolean paired(char c1,char c2){
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }
}
