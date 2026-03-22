class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int[] freq = new int[26];

        int left = 0;
        int maxfreq = 0;
        int maxlen = 0;

        for(int i=0; i<answerKey.length(); i++){
            char ch = answerKey.charAt(i);
            freq[ch - 'A']++;

            maxfreq = Math.max(maxfreq, freq[ch - 'A']);

            while((i - left + 1)-maxfreq > k){
                freq[answerKey.charAt(left) - 'A']--;
                left++;
            }

            maxlen = Math.max((i - left + 1), maxlen);
        }
        return maxlen;
    }
}