package daily;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author kanglo
 * @create 2021-03-2021/3/20 21:03
 */
public class EvalRPN {
    public int evalRPN(String[]tokens){
        Deque<Integer>stack = new ArrayDeque<>();
        for (String token : tokens){
           switch (token){
               case "+":
                   stack.push(stack.pop()+stack.pop());
                   break;
               case "*":
                   stack.push(stack.pop()*stack.pop());
                   break;
               case "-":
                   stack.push(-stack.pop()+stack.pop());
                   break;
               case "/":
                   int pre = stack.pop();
                   int cur = stack.pop();
                   stack.push(cur/pre);
                   break;
               default:
                   stack.push(Integer.parseInt(token));
           }
        }
        return stack.pop();
    }
}
