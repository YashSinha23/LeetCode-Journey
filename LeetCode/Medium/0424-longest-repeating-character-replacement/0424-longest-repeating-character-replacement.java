class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int maxfreq = 0;
        int left = 0;
        int result = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxfreq = Math.max(map.get(ch), maxfreq);

            while((i - left + 1) - maxfreq > k){
                char leftch = s.charAt(left);
                map.put(leftch, map.get(leftch)-1);
                if(map.get(leftch) == 0){
                    map.remove(leftch);
                }
                left++;
            }

            result = Math.max(result, i - left + 1);
        }

        return result;
    }
}