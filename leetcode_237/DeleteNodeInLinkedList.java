public class DeleteNodeInLinkedList {
    // 1 -> 2 -> 3 -> 4
    public void deleteNode(ListNode node) {
        if(node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public static void main(String[] args) {
        DeleteNodeInLinkedList dNILL = new DeleteNodeInLinkedList();
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        head.next = second;
        second.next = third;
        third.next = fourth;
        ListNode node = third;
        dNILL.deleteNode(node);
        ListNode t = head;
        while(t != null) {
            System.out.println(t.val);
            t = t.next;
        }
    }
}