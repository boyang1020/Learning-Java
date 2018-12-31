package com.bo;

/*

Invert a binary tree.

Ex:
     4
   /   \
  2     7
 / \   / \
1   3 6   9

to

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */

import javax.swing.tree.TreeNode;
import java.util.Deque;

public class Main {
    public class InvertTree {

        public TreeNode invertTree(TreeNode root) {

            if (root == null) return null;

            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            return root;
        }
    }
}
