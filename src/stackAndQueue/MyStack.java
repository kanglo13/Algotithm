package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    int topElement;
    Queue<Integer>queue;
    public MyStack(){
        topElement = 0;
        queue = new LinkedList<>();
    }
    public void push(int x){
        queue.offer(x);
        topElement = x;
    }
    public int pop(){
        int size = queue.size();
        while (queue.size() > 2){
            queue.offer(queue.poll());
            size--;
        }
        topElement = queue.peek();
        queue.offer(queue.poll());
        return queue.poll();
    }
    public int top(){
        return topElement;
    }
    public boolean empty(){
        return queue.isEmpty();
    }

}
