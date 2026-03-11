class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] freq = new int[256];
        int left = 0;
        int max = 0;

        for(int right=0; right<n; right++){
            char ch = s.charAt(right);
            freq[ch]++;
            while(freq[ch]>1){
                freq[s.charAt(left)]--;
                left++;
            }
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}