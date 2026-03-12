class Solution {

    boolean isvowel(char c){
        return c=='a' || c=='e'|| c=='i' || c=='o' || c=='u';
    }

    public int maxVowels(String s, int k) {

        int left = 0;
        int max = 0;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            int winsize = right - left + 1;
            if(isvowel(ch)) count++;

            if(winsize > k){
                if(isvowel(s.charAt(left))) count--;
                left++;
            }

            max = Math.max(max,count);
        }
        return max;
    }
}