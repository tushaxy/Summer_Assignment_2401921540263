class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        
        for (int i = 0; i < nums1.length; i++) {
            int target = nums1[i];
            int foundIdx = -1;
            res[i] = -1;
            
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == target) {
                    foundIdx = j;
                    break;
                }
            }
            
            for (int k = foundIdx + 1; k < nums2.length; k++) {
                if (nums2[k] > target) {
                    res[i] = nums2[k];
                    break;
                }
            }
        }
        return res;
    }
}
