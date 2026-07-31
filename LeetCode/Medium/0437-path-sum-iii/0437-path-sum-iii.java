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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        Stack<TreeNode> st = new Stack<>();

        st.push(root);

        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            if(curr.right != null){
                st.push(curr.right);
            }
            if(curr.left != null){
                st.push(curr.left);
            }

            helper(curr, (long)targetSum);
        }

        return count;
    }

    public void helper(TreeNode root, long remSum){
        if(root == null){
            return;
        }

        int val = root.val;
        remSum = remSum - val;
        if(remSum == 0){
            count++;
        }
        helper(root.left, remSum);
        helper(root.right, remSum);
    }
}