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
    public TreeNode deleteNode(TreeNode root, int key) {
        List<Integer> preorder = new ArrayList<>();
        if(root == null){
            return null;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            int val = curr.val;

            preorder.add(val);

            if(curr.right != null){
                st.push(curr.right);
            }
            if(curr.left != null){
                st.push(curr.left);
            }
        }

        // Remove the Key
        for(int i=0; i<preorder.size(); i++){
            if(preorder.get(i) == key){
                preorder.remove(i);
                break;
            }
        }

        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    int index = 0;
    public TreeNode build(List<Integer> preorder, int min, int max){
        if(index == preorder.size()){
            return null;
        }
        int val = preorder.get(index);

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