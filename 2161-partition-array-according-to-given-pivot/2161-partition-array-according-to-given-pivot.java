class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];

        int left = 0;
        for (int num : nums) {
            if (num < pivot) {
                ans[left++] = num;
            }
        }
        for (int num : nums) {
            if (num == pivot) {
                ans[left++] = num;
            }
        }
        for (int num : nums) {
            if (num > pivot) {
                ans[left++] = num;
            }
        }
        return ans;
    }
}