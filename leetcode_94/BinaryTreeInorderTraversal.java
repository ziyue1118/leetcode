import java.util.List;
import java.util.ArrayList;

public class BinaryTreeInorderTraversal {
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
        BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();
        //      _______6______
        //     /              \
        //  ___2__          ___8__
        // /      \        /      \
        // 0      _4       7       9
        //       /  \
        //       3   5
        // Should return: {0, 2, 3, 4, 5, 6, 7, 8, 9}
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
        List<Integer> result = btit.inorderTraversal(root);
        for(int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i).toString() + " ");
        }
    }
}