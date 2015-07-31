import java.util.List;
import java.util.ArrayList;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        } else {
            if (root.left != null && root.right != null) {
                TreeNode temp = invertTree(root.left);
                root.left = invertTree(root.right);
                root.right = temp;
            } else if (root.left == null) {
                root.left = invertTree(root.right);
                root.right = null;
            } else if (root.right == null) {
                root.right = invertTree(root.left);
                root.left = null;
            }
            return root;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversalResult = new ArrayList<Integer>();
        if (root == null) {
            return traversalResult;
        }
        traversalResult.addAll(inorderTraversal(root.left));
        traversalResult.add(root.val);
        traversalResult.addAll(inorderTraversal(root.right));
        return traversalResult;
    }

    public static void main(String[] args) {
        InvertBinaryTree ibt = new InvertBinaryTree();
        //      _______6______
        //     /              \
        //  ___2__          ___8__
        // /      \        /      \
        // 0      _4_      7       9
        //       /   \
        //       3    5
        //          _______6______
        //         /              \
        //      ___8__          ___2__
        //     /      \        /      \
        //    9        7     _4_       0
        //                  /   \
        //                  5    3
        // Should return: {9, 8, 7, 6, 5, 4, 3, 2, 0}
        // Pay attention to the tree like this: {2, null, 3, null, 1}
        TreeNode root = new TreeNode(6);
        TreeNode node10 = new TreeNode(2);
        TreeNode node11 = new TreeNode(8);
        TreeNode node20 = new TreeNode(0);
        TreeNode node21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(7);
        TreeNode node23 = new TreeNode(9);
        TreeNode node30 = new TreeNode(3);
        TreeNode node31 = new TreeNode(5);
        root.left = node10;
        root.right = node11;
        node10.left = node20;
        node10.right = node21;
        node11.left = node22;
        node11.right = node23;
        node21.left = node30;
        node21.right = node31;
        TreeNode r = ibt.invertTree(root);
        List<Integer> result = ibt.inorderTraversal(r);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(Integer.toString(result.get(i)) + " ");
        }
    }
}