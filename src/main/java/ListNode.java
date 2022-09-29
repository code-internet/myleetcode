/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2022/8/1
 * Time: 14:13
 * Description:
 **/
public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

    /**
     * 尾插法
     * @param arr
     * @return
     */
    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            current.next = node;
            current = current.next;
        }
        return head;
    }

    /**
     * 头插法
     * @param arr
     * @return
     */
    public static ListNode createLinkedHeadList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            node.next = current;
            current = node;
        }
        return current;
    }

    /**
     * 头结点删除链表
     * @return
     */
    public static ListNode deletedLinkedHeadList(ListNode head) {
        if (head == null) {
            return head;
        }
        head = head.next;
        return head;
    }
    /**
     * 尾结点删除链表
     * @return
     */
    public static ListNode deletedLinkedList(ListNode head) {
        if (head == null) {
            return head;
        }
        while (head.next.next!=null){
            head = head.next;

        }
        head.next = null;
        return head;
    }


    public static void printLinkedList(ListNode head){
        ListNode current =  head;
        while (current!=null){
            System.out.printf("%d -> ",current.val);
            current = current.next;
        }
        System.out.println("NULL");
    }
}