class Solution {
    public int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;
        
        int idx = 0;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[idx]) {
                idx++;
                arr[idx] = arr[i];
            }
        }
        
        return idx + 1;
    }
}
