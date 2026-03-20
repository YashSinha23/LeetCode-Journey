class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) return result;

        int windowSum = 0;
        int start, end;

        if (k > 0) {
            start = 1;
            end = k;
            for (int i = start; i <= end; i++) {
                windowSum += code[i % n];
            }
            for (int i = 0; i < n; i++) {
                result[i] = windowSum;
                windowSum -= code[start % n];
                start++;
                end++;
                windowSum += code[end % n];
            }
        }
        else {
            k = -k;
            start = n - k;
            end = n - 1;
            for (int i = start; i <= end; i++) {
                windowSum += code[i];
            }

            for (int i = 0; i < n; i++) {
                result[i] = windowSum;
                windowSum -= code[start % n];
                start++;
                end++;
                windowSum += code[end % n];
            }
        }
        return result;
    }
}