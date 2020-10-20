package interview;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author kanglo
 * @create 2020-10-2020/10/20 11:49
 */
public class EvalRPN {
    public int evalRPN(String[]tokens){
        Deque<Integer>stack = new ArrayDeque<>();
        for (String token : tokens){
            switch (token){
                case "+" :
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int num = stack.pop();
                    stack.push(stack.pop()-num);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int num1 = stack.pop();
                    stack.push(stack.pop()/num1);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
