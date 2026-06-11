class Solution {
    public String decodeString(String s) {
        return parse(s, new int[]{0});
    }
    
    private String parse(String s, int[] idx) {
        StringBuilder res = new StringBuilder();
        int num = 0;
        
        while (idx[0] < s.length()) {
            char ch = s.charAt(idx[0]);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                idx[0]++;
            } else if (ch == '[') {
                idx[0]++;
                String nested = parse(s, idx);
                idx[0]++; 
                while (num > 0) {
                    res.append(nested);
                    num--;
                }
            } else if (ch == ']') {
                break;
            } else {
                res.append(ch);
                idx[0]++;
            }
        }
        return res.toString();
    }
}
