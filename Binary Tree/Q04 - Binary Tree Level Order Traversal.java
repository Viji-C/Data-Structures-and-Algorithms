/* 102. Binary Tree Level Order Traversal - 102. Binary Tree Level Order Traversal
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000 */


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

// Iterative Approach - Using Queue
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            list.add(level);
        }
        return list;
    }
}

// Recursive Approach
class Solution {
    List<List<Integer>> list = null;
    private void levelOrderRecursive(TreeNode root, int level)
    {
        if(root == null) return;

        if(level == list.size()) list.add(new ArrayList<>());

        list.get(level).add(root.val);
        levelOrderRecursive(root.left, level+1);
        levelOrderRecursive(root.right, level+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        list = new ArrayList<>();
        levelOrderRecursive(root, 0);
        return list;
    }
}