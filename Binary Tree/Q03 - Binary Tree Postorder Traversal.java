/* 145. Binary Tree Postorder Traversal - https://leetcode.com/problems/binary-tree-postorder-traversal

Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,6,7,5,2,9,8,3,1]

Example 3:

Input: root = []
Output: []

Example 4:

Input: root = [1]
Output: [1]

Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100 */

// Recursive Sollution - PostOrder Traversal (left, right, root)
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return postOrderHelper(root, list);
    }

    private List<Integer> postOrderHelper(TreeNode node, List<Integer> list)
    {
        if (node == null) return new ArrayList<>();
        postOrderHelper(node.left, list);
        postOrderHelper(node.right, list);
        list.add(node.val);
        return list;
    }
}

// Iterative Solution (Using Two Stack)
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty())
        {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.left != null) stack1.push(node.left);
            if(node.right != null) stack1.push(node.right);
        }
        while(!stack2.isEmpty())
        {
            result.add(stack2.pop().val);
        }
        return result;
    }
}

// Iterative Approach (using Single Stack)
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || !st.isEmpty())
        {
            if(curr!= null)
            {
                st.push(curr);
                curr = curr.left;
            }
            else
            {
                TreeNode temp = st.peek().right;
                if(temp == null)
                {
                    temp = st.pop();
                    result.add(temp.val);
                    while(!st.isEmpty() && temp == st.peek().right)
                    {
                        temp = st.pop();
                        result.add(temp.val);
                    }
                }
                else
                {
                    curr = temp;
                }
            }
        }
        
        return result;
    }
}

// Other Solution 
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        TreeNode lastVisited = null;
        while(curr!=null || !st.isEmpty())
        {
            if(curr!= null)
            {
                st.push(curr);
                curr = curr.left;
            }
            else
            {
                TreeNode peekNode = st.peek();
                if(peekNode.right != null && peekNode.right != lastVisited)
                {
                    curr = peekNode.right;
                }
                else
                {
                    lastVisited = st.pop();
                    result.add(peekNode.val);
                }
            }
        }
        return result;
    }
}