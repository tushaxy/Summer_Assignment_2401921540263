import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = numStack.pop();
                int a = numStack.pop();
                
                if (token.equals("+")) numStack.push(a + b);
                else if (token.equals("-")) numStack.push(a - b);
                else if (token.equals("*")) numStack.push(a * b);
                else if (token.equals("/")) numStack.push(a / b);
            } else {
                numStack.push(Integer.parseInt(token));
            }
        }
        
        return numStack.pop();
    }
}
