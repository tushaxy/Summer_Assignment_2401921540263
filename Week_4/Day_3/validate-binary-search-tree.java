class Solution {
    public boolean isValidBST(TreeNode root) {
        return validateBounds(root, null, null);
    }
    
    private boolean validateBounds(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }
        
        if ((low != null && node.val <= low) || (high != null && node.val >= high)) {
            return false;
        }
        
        boolean leftValid = validateBounds(node.left, low, node.val);
        boolean rightValid = validateBounds(node.right, node.val, high);
        
        return leftValid && rightValid;
    }
}
