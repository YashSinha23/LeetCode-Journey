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
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, 0, targetSum);

        return res;
    }

    public void helper(TreeNode root, int currSum, int targetSum){
        if(root == null){
            return;
        }

        currSum += root.val;
        list.add(root.val);

        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                res.add(new ArrayList<>(list));
            }
        }

        helper(root.left, currSum, targetSum);
        helper(root.right, currSum, targetSum);

        list.remove(list.size() - 1);
    }
}