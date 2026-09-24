class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        stack.push(val);
        if(minStack.empty()){
            minStack.push(val);
        }
        else{
            minStack.push(Math.min(minStack.peek(), val));
        } 
    }
    
    public void pop() {
        stack.pop();
        minStack.pop(); 
    }
    
    public int top() {
       int top = stack.peek();
       return top;
    }
    
    public int getMin() {
        int minValue = minStack.peek();
        return minValue;
    }
}
