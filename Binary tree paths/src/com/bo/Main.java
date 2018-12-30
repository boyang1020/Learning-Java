/*
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.
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
    static List<String> binaryTreePaths(TreeNode root) {
        String sb = "";
        ArrayList<String> res = new ArrayList<String>();
        helper(root, res, sb);
        return res;
    }
    static void helper(TreeNode root, ArrayList<String> res, String s){
        if(root== null){
            return;
        }
        s = s+"- >" + root.val;

        if(root.left == null && root.right == null){
            res.add(s.substring(2));
            return;
        }
        if(root.left != null){
            helper(root.left, res, s);
        }
        if(root.right != null){
            helper(root.right, res, s);
        }
    }




    /***********************************************************/

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
        List<String> res;

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
        res = binaryTreePaths(root);
        Collections.sort(res);
        for(int res_i=0; res_i < res.size(); res_i++) {
            System.out.println(res.get(res_i));
        }

    }
}
