package stack;

import java.util.Stack;

class MinStack {
    public Stack<Integer> data;
    public Stack<Integer> min;

    public MinStack() {
        data = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    public void push(int val) {
        data.push(val);
        if(min.isEmpty() || min.peek()>val){
            min.push(val);
        } else {
            min.push(min.peek());
        }
        
    }
    
    public void pop() {
        data.pop();
        min.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}