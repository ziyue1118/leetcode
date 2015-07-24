import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversalResult = new ArrayList<Integer>();
        if (root == null) {
            return traversalResult;
        }
        traversalResult.add(root.val);
        traversalResult.addAll(preorderTraversal(root.left));
        traversalResult.addAll(preorderTraversal(root.right));
        return traversalResult;
    }


    public static void main(String[] args) {
        BinaryTreePreorderTraversal btpt = new BinaryTreePreorderTraversal();
        //      _______6______
        //     /              \
        //  ___2__          ___8__
        // /      \        /      \
        // 0      _4       7       9
        //       /  \
        //       3   5
        // Should return: {6, 2, 0, 4, 3, 5, 8, 7, 9}
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
        List<Integer> result = btpt.preorderTraversal(root);
        for(int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i).toString() + " ");
        }
    }
}