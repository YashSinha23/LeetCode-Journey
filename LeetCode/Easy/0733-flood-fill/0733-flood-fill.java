class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue = new ArrayDeque<>();

        int ogclr = image[sr][sc];

        if (ogclr == color) {
            return image;
        } else {
            queue.add(new int[] { sr, sc });
        }

        int row = image.length;
        int col = image[0].length;

        while (!queue.isEmpty()) {
            int curr[] = queue.poll();

            int r = curr[0];
            int c = curr[1];

            image[r][c] = color;

            if (r - 1 >= 0 && image[r - 1][c] == ogclr) {
                image[r - 1][c] = color;
                queue.add(new int[] { r - 1, c });
            }
            if (r + 1 < row && image[r + 1][c] == ogclr) {
                image[r + 1][c] = color;
                queue.add(new int[] { r + 1, c });
            }
            if (c - 1 >= 0 && image[r][c - 1] == ogclr) {
                image[r][c - 1] = color;
                queue.add(new int[] { r, c - 1 });
            }
            if (c + 1 < col && image[r][c + 1] == ogclr) {
                image[r][c + 1] = color;
                queue.add(new int[] { r, c + 1 });
            }
        }

        return image;
    }
}