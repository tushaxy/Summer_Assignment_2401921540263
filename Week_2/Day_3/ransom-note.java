class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] arr1 = ransomNote.toCharArray();
        char[] arr2 = magazine.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int[] count = new int[26];
        if(arr1.length>arr2.length) return false;
        for(int i = 0;i<arr2.length;i++){
            count[arr2[i]-'a']++;
        }
        for(int i =0;i<arr1.length;i++){
            count[arr1[i]-'a']--;
        }
        for(int i=0;i<26;i++){
            if(count[i]<0) return false;
        }
        return true;
    }
}
