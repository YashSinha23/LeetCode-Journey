class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = m + n;

        int ptr1 = 0, ptr2 = 0;
        int prev = 0, curr = 0;

        for (int i = 0; i <= k / 2; i++) {
            prev = curr;

            if (ptr1 < m && (ptr2 >= n || nums1[ptr1] <= nums2[ptr2])) {
                curr = nums1[ptr1++];
            } else {
                curr = nums2[ptr2++];
            }
        }

        if (k % 2 == 0) {
            return (prev + (double) curr) / 2.0;
        }

        return curr;
    }
}