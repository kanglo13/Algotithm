package stackAndQueue;

import java.util.Stack;

public class MinStack {
    private Stack<Integer>dataStack;
    private Stack<Integer>minStack;
    public MinStack(){
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int x){
        dataStack.push(x);
        if (minStack.isEmpty())
            minStack.push(x);
        else
            minStack.push(minStack.pop() < x ?minStack.pop() : x);
    }
    public void pop(int x){
        dataStack.pop();
        minStack.pop();
    }
    public int top(){
        return dataStack.peek();
    }
    public int min(){
        return minStack.peek();
    }
}
