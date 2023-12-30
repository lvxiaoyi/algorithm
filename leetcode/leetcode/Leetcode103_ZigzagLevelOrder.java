package leetcode;


import leetcode.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: lvxiaoyi
 * @Description: 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * @DateTime: 2023/12/21 22:57
 */


public class Leetcode103_ZigzagLevelOrder {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        System.out.println(new Leetcode103_ZigzagLevelOrder().zigzagLevelOrder(treeNode1));
    }

    /**
     * @Author: lvxiaoyi
     * @Description: Z字型遍历，在广度遍历的规则上添加一层，如果当层的队列size遍历完成则从队列末尾取值否则继续从队列开始取值
     * @DateTime: 2023/12/21 23:00
     */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) return new LinkedList<>();
        queue.offer(root);
        boolean isReverse = false;

        while (!queue.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 按照从左到右依次遍历
                if (!isReverse) {
                    TreeNode node = queue.pollFirst();
                    if (node == null) break;
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                    temp.add(node.val);
                } else {
                    // 按照从右到左依次遍历
                    TreeNode node = queue.pollLast();
                    if (node == null) break;
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                    temp.add(node.val);
                }
            }
            isReverse = !isReverse;
            result.add(temp);
        }
        return result;
    }


    /**
     * @Author: lvxiaoyi
     * @Description:
     *
     * 这种是通过改变插入字符串的位置，实现最终的结果
     *
     * @DateTime: 2023/12/21 23:50
     */

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isReverse = false;

        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (isReverse) {
                    level.add(0, node.val); // 在头部插入，实现从右到左顺序
                } else {
                    level.add(node.val); // 在尾部追加，实现从左到右顺序
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(level);
            isReverse = !isReverse;
        }

        return result;
    }

}
