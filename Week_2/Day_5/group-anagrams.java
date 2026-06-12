import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        HashMap<String, List<String>> lookup = new HashMap<>();
        
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String signature = new String(chars);
            
            if (!lookup.containsKey(signature)) {
                lookup.put(signature, new ArrayList<>());
            }
            lookup.get(signature).add(word);
        }
        
        return new ArrayList<>(lookup.values());
    }
}
