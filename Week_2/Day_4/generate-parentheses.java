import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        buildTree(combinations, new StringBuilder(), 0, 0, n);
        return combinations;
    }
    
    private void buildTree(List<String> list, StringBuilder current, int open, int close, int limit) {
        if (current.length() == limit * 2) {
            list.add(current.toString());
            return;
        }
        
        if (open < limit) {
            current.append('(');
            buildTree(list, current, open + 1, close, limit);
            current.deleteCharAt(current.length() - 1);
        }
        
        if (close < open) {
            current.append(')');
            buildTree(list, current, open, close + 1, limit);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
