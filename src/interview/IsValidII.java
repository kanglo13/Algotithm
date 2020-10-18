package interview;

import java.util.Stack;

/**
 * @author kanglo
 * @create 2020-10-2020/10/16 21:09
 */
public class IsValidII {
    public boolean isValid(String s){
        if (s == null || s.length() == 0)
            return true;
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
        return true;
    }
    private boolean isPaired(char ch1, char ch2){
        return (ch1 == '(' && ch2 == ')') || (ch1 == '[' && ch2 == ']') || (ch1 == '{' && ch2 == '}');
    }
}
