/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /*
    ************************************************************/
    static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        } if(getHeight(root) == -1){
            return false;
        }
        return true;
    }
    static int getHeight(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if(left == -1 || right == -1)  {
            return -1;
        } if(Math.abs(left -right) > 1) {
            return -1;
        } return Math.max(left, right) + 1;
    }


    /************************************************************/

    static int preIndex = 0;
    private static TreeNode buildTree(int in[], int pre[], int inStrt, int inEnd) {
        if (inStrt > inEnd)
            return null;

        /* Pick current node from Preorder traversal using preIndex
           and increment preIndex */
        TreeNode tNode = new TreeNode(pre[preIndex++]);

        /* If this node has no children then return */
        if (inStrt == inEnd)
            return tNode;

        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(in, inStrt, inEnd, tNode.val);

        /* Using index in Inorder traversal, construct left and
           right subtress */
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);

        return tNode;
    }

    /* UTILITY FUNCTIONS */

    /* Function to find index of value in arr[start...end]
     The function assumes that value is present in in[] */
    private static int search(int arr[], int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++)
        {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean res;

        int _root_rows = 0;
        int _root_cols = 0;
        _root_rows = Integer.parseInt(in.nextLine().trim());
        _root_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _root = new int[_root_rows][_root_cols];
        for(int _root_i=0; _root_i<_root_rows; _root_i++) {
            for(int _root_j=0; _root_j<_root_cols; _root_j++) {
                _root[_root_i][_root_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        TreeNode root = buildTree(_root[0], _root[1], 0, _root_cols - 1);
        res = isBalanced(root);
        System.out.println(res);
    }
}
