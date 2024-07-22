package stackandqueues.easy.problem8;

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class MinStack {

    Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int min;
        if (stack.isEmpty()) {
            min = val;
        } else {
            min = Math.min(stack.peek().y, val);
        }
        stack.push(new Pair(val, min));
    }
    
    public void pop() {
        if(!stack.isEmpty()) {
            stack.pop();
        }
    }
    
    public int top() {
        if(!stack.isEmpty()) {
            return stack.peek().x;
        }
        return -1;
    }
    
    public int getMin() {
        if(stack.isEmpty()) {
            return -1;
        } else {
            Pair top = stack.peek();
            return top.y;
        } 
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
