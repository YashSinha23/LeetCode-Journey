class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0) {
            return "";
        }

        int rightidx = Integer.MAX_VALUE;
        int leftidx = 0;

        HashMap<Character, Integer> required = new HashMap<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            required.put(ch, required.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int formed = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (required.containsKey(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.get(ch) <= required.get(ch)) {
                    formed++;
                }
            }

            while (formed == t.length()) {
                if (right - left < rightidx - leftidx) {
                    rightidx = right;
                    leftidx = left;
                }

                char leftChar = s.charAt(left);

                if (required.containsKey(leftChar)) {
                    if (map.get(leftChar) <= required.get(leftChar)) {
                        formed--;
                    }

                    map.put(leftChar, map.get(leftChar) - 1);

                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                }
                left++;
            }
        }

        if (rightidx == Integer.MAX_VALUE) {
            return "";
        }

        String result = s.substring(leftidx, rightidx + 1);

        return result;

    }
}