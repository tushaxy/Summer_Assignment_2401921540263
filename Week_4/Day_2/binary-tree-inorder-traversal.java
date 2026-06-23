import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> sequence = new ArrayList<>();
        traverseInorder(root, sequence);
        return sequence;
    }
    
    private void traverseInorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        
        traverseInorder(node.left, list);
        list.add(node.val);
        traverseInorder(node.right, list);
    }
}
