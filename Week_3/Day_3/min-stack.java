import java.util.Stack;

class MinStack {
    private Stack<Integer> primaryStack;
    private Stack<Integer> minTrackerStack;

    public MinStack() {
        primaryStack = new Stack<>();
        minTrackerStack = new Stack<>();
    }
    
    public void push(int val) {
        primaryStack.push(val);
        
        if (minTrackerStack.isEmpty() || val <= minTrackerStack.peek()) {
            minTrackerStack.push(val);
        } else {
            minTrackerStack.push(minTrackerStack.peek());
        }
    }
    
    public void pop() {
        if (!primaryStack.isEmpty()) {
            primaryStack.pop();
            minTrackerStack.pop();
        }
    }
    
    public int top() {
        return primaryStack.peek();
    }
    
    public int getMin() {
        return minTrackerStack.peek();
    }
}
