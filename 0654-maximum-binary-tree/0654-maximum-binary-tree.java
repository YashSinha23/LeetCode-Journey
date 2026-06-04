/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        return build(left, right, nums);
    }

    public TreeNode build(int left, int right, int[] nums){
        if(left > right){
            return null;
        }

        int maxIndex = left;
        for(int i = left; i <= right; i++){
            if(nums[i] > nums[maxIndex]){
            maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);

        root.left = build(left, maxIndex - 1, nums);
        root.right = build(maxIndex + 1, right, nums);

        return root;
    }
}