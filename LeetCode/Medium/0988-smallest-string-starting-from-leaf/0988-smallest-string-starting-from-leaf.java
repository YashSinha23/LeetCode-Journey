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
    String result = null;
    public String smallestFromLeaf(TreeNode root) {
        helper(root,"");
        return result;
    }

    public void helper(TreeNode root, String str){
        if(root == null){
            return;
        }

        int val = root.val;
        str = (char)('a' + val) + str;

        if(root.left == null && root.right == null){
            if(result==null || str.compareTo(result) < 0){
                result = str;
                return;
            }
        }

        helper(root.left, str);
        helper(root.right, str);
        
        return;
    }
}