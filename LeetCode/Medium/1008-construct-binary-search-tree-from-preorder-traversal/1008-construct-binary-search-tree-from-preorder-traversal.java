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
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return build(preorder, min, max);
    }

    public TreeNode build(int[] preorder, int min, int max){
        if(index == preorder.length){
            return null;
        }

        int val = preorder[index];
        if(val < min || val > max){
            return null;
        }

        index++;
        TreeNode root = new TreeNode(val);
        root.left = build(preorder, min, val);
        root.right = build(preorder, val, max);

        return root;
    }
}