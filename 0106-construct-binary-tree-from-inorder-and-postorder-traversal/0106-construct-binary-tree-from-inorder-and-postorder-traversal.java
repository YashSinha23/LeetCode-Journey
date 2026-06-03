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
    HashMap<Integer, Integer> map = new HashMap<>();
    int poi = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        poi = postorder.length - 1;
        return build(0, inorder.length - 1, postorder);
    }

    public TreeNode build(int left, int right, int[] postorder){
        if(left > right){
            return null;
        }

        int poe = postorder[poi--];
        TreeNode root = new TreeNode(poe);
        int ioi = map.get(poe);

        root.right = build(ioi + 1, right, postorder);
        root.left = build(left, ioi - 1, postorder);

        return root;
    }
}