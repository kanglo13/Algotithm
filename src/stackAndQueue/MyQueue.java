package stackAndQueue;

import java.util.Stack;

public class MyQueue {
    Stack<Integer>stack1;
    Stack<Integer>stack2;
    public MyQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public void push(int x){
        stack1.push(x);
    }
    public int peek(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    public int pop(){
        peek();
        return stack2.pop();
    }
    public boolean empty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
