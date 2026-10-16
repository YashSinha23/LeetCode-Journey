class Solution {
    private static final long MOD = 1_000_000_007L;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        int[] lastSeen = new int[100001];
        Arrays.fill(lastSeen, -1);

        SegmentTree tree = new SegmentTree(n);
        long answer = 0;

        for (int r = 0; r < n; r++) {
            int x = nums[r];
            int prev = lastSeen[x];

            tree.update(prev + 1, r, 1);
            answer = (answer + tree.sumSq[1]) % MOD;

            lastSeen[x] = r;
        }

        return (int) answer;
    }

    class SegmentTree {
        long[] sum;
        long[] sumSq;
        long[] lazy;
        int n;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sumSq = new long[4 * n];
            lazy = new long[4 * n];
        }

        void apply(int node, int l, int r, long delta) {
            long len = r - l + 1L;

            sumSq[node] = (sumSq[node]
                    + 2L * delta * sum[node]
                    + delta * delta % MOD * len) % MOD;

            sum[node] = (sum[node] + delta * len) % MOD;
            lazy[node] = (lazy[node] + delta) % MOD;
        }

        void push(int node, int l, int r) {
            if (lazy[node] == 0 || l == r) {
                return;
            }

            int mid = l + (r - l) / 2;

            apply(node * 2, l, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, r, lazy[node]);

            lazy[node] = 0;
        }

        void update(int ql, int qr, long delta) {
            update(1, 0, n - 1, ql, qr, delta);
        }

        void update(int node, int l, int r, int ql, int qr, long delta) {
            if (ql <= l && r <= qr) {
                apply(node, l, r, delta);
                return;
            }

            push(node, l, r);

            int mid = l + (r - l) / 2;

            if (ql <= mid) {
                update(node * 2, l, mid, ql, qr, delta);
            }

            if (qr > mid) {
                update(node * 2 + 1, mid + 1, r, ql, qr, delta);
            }

            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
            sumSq[node] = (sumSq[node * 2] + sumSq[node * 2 + 1]) % MOD;
        }
    }
}