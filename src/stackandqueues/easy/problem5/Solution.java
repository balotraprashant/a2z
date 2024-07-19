package stackandqueues.easy.problem5;

import java.util.Stack;

class MyQueue {

    Stack<Integer> input = new Stack<>();
    Stack <Integer> output = new Stack<>();

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        while (!input.empty()) {
            output.push(input.peek());
            input.pop();
        }
        // Insert the desired element in the stack input
        input.push(x);
        // Pop out elements from the stack output and push them into the stack input
        while (!output.empty()) {
            input.push(output.peek());
            output.pop();
        }
    }
    
    public int pop() {
        if (input.empty()) {
            return -1;
        }
        return input.pop();
    }
    
    public int peek() {
        if (input.empty()) {
            return -1;
        }
        return input.peek();
    }
    
    public boolean empty() {
        return input.size()==0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
