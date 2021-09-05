package leetcode.editor.cn;
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 831 👎 0

import java.util.*;

public class P102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (null == root) {
                return result;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);

            while (!queue.isEmpty()){
                List<Integer> list = new ArrayList<>();
                List<TreeNode> nodeList = new ArrayList<>();
                while (!queue.isEmpty()) {
                    nodeList.add(queue.poll());
                }
                for (TreeNode node : nodeList) {
                    list.add(node.val);
                    if (null != node.left) {
                        queue.add(node.left);
                    }
                    if (null != node.right) {
                        queue.add(node.right);
                    }
                }
                result.add(list);
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}