import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int ns = s.length();
        int np = p.length();
        
        if (ns < np) return result;
        
        int[] countP = new int[26];
        int[] countS = new int[26];
        
        for (int i = 0; i < np; i++) {
            countP[p.charAt(i) - 'a']++;
            countS[s.charAt(i) - 'a']++;
        }
        
        boolean match = true;
        for (int j = 0; j < 26; j++) {
            if (countP[j] != countS[j]) match = false;
        }
        if (match) result.add(0);
        
        for (int i = np; i < ns; i++) {
            countS[s.charAt(i) - 'a']++;
            countS[s.charAt(i - np) - 'a']--;
            
            boolean isValid = true;
            for (int j = 0; j < 26; j++) {
                if (countP[j] != countS[j]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                result.add(i - np + 1);
            }
        }
        
        return result;
    }
}
