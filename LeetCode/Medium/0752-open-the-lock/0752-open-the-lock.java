class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new ArrayDeque<>();
        if (visited.contains("0000")) {
            return -1;
        }
        queue.add("0000");
        visited.add("0000");
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(target)) {
                    return count;
                }
                for (int j = 0; j < 4; j++) {
                    char[] chars = curr.toCharArray();

                    // Increment
                    if (chars[j] == '9') {
                        chars[j] = '0';
                    } else {
                        chars[j]++;
                    }
                    String up = new String(chars);
                    if (!visited.contains(up)) {
                        queue.add(up);
                        visited.add(up);
                    }

                    // Decrement
                    chars = curr.toCharArray();
                    if (chars[j] == '0') {
                        chars[j] = '9';
                    } else {
                        chars[j]--;
                    }
                    String down = new String(chars);
                    if (!visited.contains(down)) {
                        queue.add(down);
                        visited.add(down);
                    }

                    if (up.equals(target) || down.equals(target)) {
                        return count + 1;
                    }
                }
            }
            count++;
        }
        return -1;
    }
}