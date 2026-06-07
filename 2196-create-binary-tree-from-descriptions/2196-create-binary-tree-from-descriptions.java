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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> children = new HashSet<>();
        for (int[] d : descriptions) {
            children.add(d[1]);
        }
        int rootVal = -1;

        for (int[] d : descriptions) {
            if (!children.contains(d[0])) {
                rootVal = d[0];
                break;
            }
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < descriptions.length; i++) {
            int parent = descriptions[i][0];

            map.putIfAbsent(parent, new ArrayList<>());
            map.get(parent).add(i);
        }

        return build(rootVal, descriptions, map);

    }

    public TreeNode build(int val, int[][] descriptions, HashMap<Integer, List<Integer>> map){

        TreeNode root = new TreeNode(val);

        if(!map.containsKey(val)){
            return root;
        }

        for(int idx : map.get(val)){
            int childVal = descriptions[idx][1];
            int isLeft = descriptions[idx][2];

            TreeNode childNode = build(childVal, descriptions, map);

            if(isLeft == 1){
                root.left = childNode;
            }else{
                root.right = childNode;
            }
        }
        return root;
    }
}