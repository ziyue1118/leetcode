import java.util.List;
import java.util.ArrayList;

public class PopulateNextRightPointer {
    // The idea is to use recursion. If you know the (i-1) level next node, you can
    // get i level next node.
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }

        TreeLinkNode p = root;

        while(p != null) {
            if (p.next != null) {
                p.left.next = p.right;
                p.right.next = p.next.left;
            } else {
                p.left.next = p.right;
                p.right.next = null;
            }
            p = p.next;
        }
        connect(root.left);
    }

    public void printValue(TreeLinkNode node) {
        if (node != null) {
            System.out.println(node.val);
        } else {
            System.out.println("NULL");
        }
    }

    public List<TreeLinkNode> inorderTraversal(TreeLinkNode root) {
        List<TreeLinkNode> traversalResult = new ArrayList<TreeLinkNode>();
        if (root == null) {
            return traversalResult;
        }
        traversalResult.addAll(inorderTraversal(root.left));
        traversalResult.add(root);
        traversalResult.addAll(inorderTraversal(root.right));
        return traversalResult;
    }

    public static void main(String[] args) {
        PopulateNextRightPointer pnrp = new PopulateNextRightPointer();
        //      _______6______
        //     /              \
        //  ___2__          ___8__
        // /      \        /      \
        // 0       4       7       9
        TreeLinkNode root = new TreeLinkNode(6);
        TreeLinkNode node10 = new TreeLinkNode(2);
        TreeLinkNode node11 = new TreeLinkNode(8);
        TreeLinkNode node20 = new TreeLinkNode(0);
        TreeLinkNode node21 = new TreeLinkNode(4);
        TreeLinkNode node22 = new TreeLinkNode(7);
        TreeLinkNode node23 = new TreeLinkNode(9);
        root.left = node10;
        root.right = node11;
        node10.left = node20;
        node10.right = node21;
        node11.left = node22;
        node11.right = node23;
        pnrp.connect(root);
        List<TreeLinkNode> traversalResult = pnrp.inorderTraversal(root);
        for(int i = 0; i < traversalResult.size(); i++) {
            System.out.print("Node value(" + Integer.toString(traversalResult.get(i).val) + ") next is: ");
            pnrp.printValue(traversalResult.get(i).next);
        }
    }
}