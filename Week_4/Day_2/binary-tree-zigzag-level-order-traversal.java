import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagMasterList = new ArrayList<>();
        if (root == null) return zigzagMasterList;
        
        Queue<TreeNode> traversalQueue = new LinkedList<>();
        traversalQueue.offer(root);
        boolean reverseDirection = false;
        
        while (!traversalQueue.isEmpty()) {
            int itemsInLevel = traversalQueue.size();
            LinkedList<Integer> horizontalRow = new LinkedList<>();
            
            for (int i = 0; i < itemsInLevel; i++) {
                TreeNode targetNode = traversalQueue.poll();
                
                if (reverseDirection) {
                    horizontalRow.addFirst(targetNode.val);
                } else {
                    horizontalRow.addLast(targetNode.val);
                }
                
                if (targetNode.left != null) {
                    traversalQueue.offer(targetNode.left);
                }
                if (targetNode.right != null) {
                    traversalQueue.offer(targetNode.right);
                }
            }
            
            zigzagMasterList.add(horizontalRow);
            reverseDirection = !reverseDirection;
        }
        
        return zigzagMasterList;
    }
}
