class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long[] diff = new long[nums1.length];
        long totalDiff = 0;
        long maxDiff = 0;

        for (int i = 0; i < nums1.length; i++) {
            diff[i] = Math.abs((long) nums1[i] - nums2[i]);
            totalDiff += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        long k = (long) k1 + k2;

        if (k >= totalDiff) {
            return 0;
        }

        long low = 0, high = maxDiff;

        while (low < high) {
            long mid = low + (high - low) / 2;
            long operations = 0;

            for (long d : diff) {
                if (d > mid) {
                    operations += d - mid;
                }
            }

            if (operations <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long limit = low;
        long operations = 0;

        for (long d : diff) {
            if (d > limit) {
                operations += d - limit;
            }
        }

        long remaining = k - operations;
        long result = 0;

        for (long d : diff) {
            long reduced = Math.min(d, limit);
            if (reduced == limit && remaining > 0 && d >= limit) {
                reduced--;
                remaining--;
            }
            result += reduced * reduced;
        }

        return result;
    }
}