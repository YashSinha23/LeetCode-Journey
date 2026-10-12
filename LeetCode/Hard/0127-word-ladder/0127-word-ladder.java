class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();

        queue.add(beginWord);
        visited.add(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                if (s.equals(endWord)) {
                    return count;
                }
                
                char[] chars = s.toCharArray();

                for (int j = 0; j < s.length(); j++) {
                    char original = chars[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original) {
                            continue;
                        }

                        chars[j] = ch;
                        String next = new String(chars);

                        if (words.contains(next) && !visited.contains(next)) {
                            queue.add(next);
                            visited.add(next);
                        }
                    }
                    chars[j] = original;
                }
            }
            count++;
        }
        return 0;
    }
}