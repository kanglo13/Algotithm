package daily;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> minStack;
    private Stack<Integer> dataStack;
    public MinStack(){
        minStack = new Stack<>();
        dataStack = new Stack<>();
    }
    public void push(int x){
        dataStack.push(x);
        minStack.push(minStack.isEmpty() ? x : Math.min(x,minStack.peek()));
    }
    public void pop(){
        int top = dataStack.pop();
        if (minStack.peek() == top)
            minStack.pop();
    }
    public int top(){
        return dataStack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }
}
