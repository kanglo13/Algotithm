package stackAndQueue.monotonicQueue;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s){
        int n = s.length();
        if (n < 2)
            return s;
        boolean[]set = new boolean[26];
        int[]lastIndex = new int[26];
        Stack<Character>stack = new Stack<>();
        for (int i = 0;i < n;i++){
            lastIndex[s.charAt(i)-'a'] = i;
        }
        for (int i = 0;i < n;i++){
            char current = s.charAt(i);
            if (set[current-'a'])
                continue;
            while (!stack.isEmpty() && current < stack.peek() && lastIndex[stack.peek()-'a'] >= i){
                char stackTop = stack.pop();
                set[stackTop-'a'] = false;
            }
            stack.push(current);
            set[current-'a'] = true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.insert(0,stack.pop());
        }
        return stringBuilder.toString();
    }
}
