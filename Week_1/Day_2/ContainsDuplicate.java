import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> cache = new HashSet<>();
        
        for (int element : nums) {
            if (!cache.add(element)) {
                return true;
            }
        }
        
        return false;
    }
}
