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
    int max = 0;
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root,0);
        return list;
    }

    public void helper(TreeNode node, int depth){
        if(node == null){
            return;
        }
        if(depth == max){
            list.add(node.val);
            max++;
        }

        helper(node.right, depth+1);
        helper(node.left, depth+1);
    }
}