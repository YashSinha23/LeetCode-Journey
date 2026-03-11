class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(char ch: s1.toCharArray()){
            arr1[ch - 'a']++;
        }

        int winsize = s1.length();

        for(int i=0; i<s2.length(); i++){
            arr2[s2.charAt(i) - 'a']++;

            if(i >= winsize){
                arr2[s2.charAt(i-winsize) - 'a']--;
            }

            if(Arrays.equals(arr1,arr2)){
                return true;
            }
        }
        return false;
    }
}