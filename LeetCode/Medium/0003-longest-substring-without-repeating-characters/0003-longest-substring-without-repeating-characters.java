class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;

        HashSet<Character> set = new HashSet<>();

        int count = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            count++;

            if (set.contains(ch)) {
                while (s.charAt(left) != ch) {
                    set.remove(s.charAt(left));
                    count--;
                    left++;
                }
                set.remove(s.charAt(left));
                count--;
                left++;

            }
            set.add(ch);
            max = Math.max(max, count);
        }
        return max;
    }
}