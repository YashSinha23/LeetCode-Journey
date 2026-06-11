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
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
            if(root == null){
                return res;
            }

            helper(root,"");
            return res;
    }

    public void helper(TreeNode node, String str){
        if(node == null){
            return;
        }

        str += node.val;

        if(node.left == null && node.right==null){
            res.add(str);
            return;
        }

        str += "->";

        helper(node.left,str);
        helper(node.right,str);
    }
    
    
}