import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> blockStack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            if (current == '(' || current == '{' || current == '[') {
                blockStack.push(current);
            } else {
                if (blockStack.isEmpty()) {
                    return false;
                }
                
                char topElement = blockStack.pop();
                if (current == ')' && topElement != '(') return false;
                if (current == '}' && topElement != '{') return false;
                if (current == ']' && topElement != '[') return false;
            }
        }
        
        return blockStack.isEmpty();
    }
}
