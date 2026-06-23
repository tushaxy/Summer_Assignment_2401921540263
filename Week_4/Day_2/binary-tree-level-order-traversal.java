import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> outputGrid = new ArrayList<>();
        if (root == null) return outputGrid;
        
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        
        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();
            List<Integer> currentLevelData = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = nodeQueue.poll();
                currentLevelData.add(current.val);
                
                if (current.left != null) {
                    nodeQueue.offer(current.left);
                }
                if (current.right != null) {
                    nodeQueue.offer(current.right);
                }
            }
            outputGrid.add(currentLevelData);
        }
        
        return outputGrid;
    }
}
