package stackAndQueue.monotonicQueue;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKDigits(String num,int k){
        if (num.length() <= k)
            return "0";
        Stack<Character>stack = new Stack<>();
        int count = 0;
        for (int i  = 0;i < num.length();i++){
            while (!stack.isEmpty() && count < k && stack.peek() > num.charAt(i)){
                stack.pop();
                count++;
            }
            stack.push(num.charAt(i));
        }
        while (count < k){
            stack.pop();
            count++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.insert(0,stack.pop());
        }
        if (stringBuilder.charAt(0) == '0' && stringBuilder.length() > 1)
            stringBuilder.deleteCharAt(0);
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }
}
