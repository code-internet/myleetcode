import java.lang.reflect.WildcardType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2022/8/1
 * Time: 14:27
 * Description:
 **/
public class ListNode_test1 {

        public static void main(String[] args) {

            int[] arr = {4, 5, 1, 9,0,6,7};
            ListNode linkedList = ListNode.createLinkedList(arr);
            ListNode listNode = getKthFromEnd(linkedList, 5);
            ListNode.printLinkedList(listNode);
        }

        public static ListNode deleteNode(ListNode head, int val) {
            if(head==null){
                return head;
            }
            ListNode temp = head;
            ListNode listNode = new ListNode(-1);
            ListNode current = listNode;
            while (temp!=null){
                if(temp.val!=val) {
                    current.next = new ListNode(temp.val);
                    current = current.next;
                }
                temp = temp.next;
            }
            return listNode.next;

        }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null){
            return head;
        }
        int count = 0;
        ListNode listNode = head;
        while (listNode!=null){
            count++;
            listNode = listNode.next;
        }
        ListNode temp = head;
        int p = 0;
        int q = count-k;
        while ( p!=q){
            p++;
            temp = temp.next;
        }
        return temp;
    }

}