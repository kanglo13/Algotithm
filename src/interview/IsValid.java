package interview;

import java.util.Stack;

/**
 * @author kanglo
 * @create 2020-10-2020/10/2 10:36
 */
public class IsValid {
    public boolean isValid(String s){
        Stack<Character>stack = new Stack<>();
        for (char ch : s.toCharArray()){
            if (ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            else {
                if (!stack.isEmpty() && isPaired(stack.peek(),ch))
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
    private boolean isPaired(char ch1,char ch2){
        return (ch1 == '(' && ch2 == ')') || (ch1 == '[' && ch2 == ']') || (ch1 == '{' && ch2 == '}');
    }
}
