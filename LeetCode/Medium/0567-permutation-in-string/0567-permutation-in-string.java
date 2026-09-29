class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch,0)+1);
        }
        
        int winsize = s1.length();

        for(int i=0; i<s2.length(); i++){
            char ch = s2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch,0)+1);

            if (i >= winsize) {
                char removeChar = s2.charAt(i - winsize);
                map2.put(removeChar, map2.get(removeChar) - 1);
                if (map2.get(removeChar) == 0) {
                    map2.remove(removeChar);
                }
            }

            if(map1.equals(map2)){
                return true;
            }
        }

        return false;
    }
}