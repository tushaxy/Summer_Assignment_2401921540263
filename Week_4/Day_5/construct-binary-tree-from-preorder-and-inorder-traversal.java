import java.util.HashMap;

class Solution {
    private int preorderTracker = 0;
    private HashMap<Integer, Integer> inorderLookupMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderLookupMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderLookupMap.put(inorder[i], i);
        }
        return construct(preorder, 0, inorder.length - 1);
    }
    
    private TreeNode construct(int[] preorder, int leftBoundary, int rightBoundary) {
        if (leftBoundary > rightBoundary) {
            return null;
        }
        
        int rootValue = preorder[preorderTracker];
        TreeNode pivotNode = new TreeNode(rootValue);
        preorderTracker++;
        
        int pivotIndex = inorderLookupMap.get(rootValue);
        
        pivotNode.left = construct(preorder, leftBoundary, pivotIndex - 1);
        pivotNode.right = construct(preorder, pivotIndex + 1, rightBoundary);
        
        return pivotNode;
    }
}
