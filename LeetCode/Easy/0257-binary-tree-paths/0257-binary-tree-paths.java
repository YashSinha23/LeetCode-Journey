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
    List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root,"");
        return list;
    }
    public TreeNode helper(TreeNode root, String st){
        if(root == null){
            return null;
        }
        int val = root.val;
        String str = st;
        if(root.left == null && root.right == null){
            str += val;
            list.add(str);
            return null;
        }else{
            str += val + "->";
        }

        helper(root.left, str);
        helper(root.right, str);
        
        return null;
    }
}