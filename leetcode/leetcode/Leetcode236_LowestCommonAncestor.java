package leetcode;


import leetcode.utils.TreeNode;

/**
 * @Author: lvxiaoyi
 * @Description:
 *
 *给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 *
 * @DateTime: 2023/12/21 22:19
 */

public class Leetcode236_LowestCommonAncestor {
    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(0);
        TreeNode treeNode7 = new TreeNode(8);
        TreeNode treeNode8 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(4);



        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode5.left = treeNode8;
        treeNode5.right = treeNode9;

        System.out.println(new Leetcode236_LowestCommonAncestor().lowestCommonAncestor(treeNode1,treeNode2,treeNode3));
    }


    /**
     * @Author: lvxiaoyi
     * @Description:
     *
     * dfs的递归，去寻找这两个节点,根据题目描述，p和q是在这两个节点里的，所以必定能找到值
     *
     * @DateTime: 2023/12/21 22:25
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }



}
