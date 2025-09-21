/* 94. Binary Tree Inorder Traversal - leetcode.com/problems/binary-tree-inorder-traversal

Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,2,6,5,7,1,3,9,8]

Example 3:

Input: root = []
Output: []

Example 4:

Input: root = [1]
Output: [1]

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100 */

// Sollution - Inorder Traversal (left, root, right)
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return inOrderHelper(root, list);
    }

    private List<Integer> inOrderHelper(TreeNode node, List<Integer> list)
    {
        if (node == null) return new ArrayList<>();
        inOrderHelper(node.left, list);
        list.add(node.val);
        inOrderHelper(node.right, list);
        return list;
    }
}

// Iterative Approach

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        // inorder(root, result);
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr!=null)
        {
            while(curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            result.add(node.val);
            curr = node.right;
        }
        return result;
    }
}

// Solution 2

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        // inorder(root, result);
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr!=null)
        {
            if(curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else
            {
                TreeNode node = stack.pop();
                result.add(node.val);
                curr = node.right;
            }
        }
        return result;
    }
}