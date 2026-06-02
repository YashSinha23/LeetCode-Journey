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

    int poi = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }

        return build(preorder, 0, inorder.length -1);

    }

    public TreeNode build(int[] preorder, int left, int right){

        if(left > right){
            return null;
        }
        
        int poe = preorder[poi++];
        TreeNode root = new TreeNode(poe);

        int ioi = map.get(poe);

        root.left = build(preorder, left, ioi - 1);
        root.right = build(preorder, ioi + 1, right);

        return root;
    }
}