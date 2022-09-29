import com.sun.jmx.remote.internal.ArrayQueue;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2022/8/15
 * Time: 17:29
 * Description:
 **/
public class test {


    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.empty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

    public static int[] levelOrder(TreeNode root) {

        if(root == null ){
            int[] a = {-1};
            return a;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            level.add(node.val);
        }
        int[] b = new int[level.size()];
        for(int i = 0;i<level.size();i++){
            b[i] =level.get(i);
        }
        return b;
    }

    public static List<List<Integer>> levelOrder1(TreeNode root) {
        List arrayList = new ArrayList();
        if(root == null){
            return arrayList;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            ArrayList arrayList1 = new ArrayList();
            int ans = queue.size();
            for(int i = 0; i<ans; i++){
                TreeNode node = queue.poll();
                arrayList1.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            arrayList.add(arrayList1);
        }
        return arrayList;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ll1 = reverseList(l1);
        System.out.println("ll1-----------------");
        ListNode.printLinkedList(ll1);
        System.out.println("ll2-----------------");
        ListNode ll2 = reverseList(l2);
        ListNode.printLinkedList(ll2);
        ListNode ll3 = addListNode(ll1,ll2);
        return reverseList(ll3);
    }

    public static ListNode reverseList(ListNode node){
        ListNode pre = null;
        ListNode temp = null;
        while(node!=null){
            temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        return pre;
    }

    public static ListNode addListNode(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode sumNode = dummy;
        int carry = 0;
        while(l1!=null || l2!=null){
            int sum = (l1==null?0:l1.val)+(l2==null?0:l2.val)+carry;
            carry = sum-10>=0?1:0;
            sum = sum-10>=0?sum-10:sum;
            ListNode t = new ListNode(sum);
            sumNode.next = t;
            sumNode = sumNode.next;
            l1= l1==null?null:l1.next;
            l2 =l2==null?null:l2.next;
        }
        if(carry >0 ){
            sumNode.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        int count = 1;
        Arrays.sort(nums);
        if(nums.length==1){
            return nums[0];
        }
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                count++;
                if(count>((nums.length-1)>>1)){
                    return nums[i];
                }
            }else {
                map.put(nums[i],nums[i]);
                count = 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] a = {1,2,2,3,4,1};
        int[] b = {2,2,3,4};
        int[] intersection = intersection(a, b);
        System.out.println();
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hashMap = new HashMap();
        HashMap<Integer,Integer> hashMap1 = new HashMap();
        for(int i = 0;i<nums1.length;i++){
            hashMap.put(nums1[i],nums1[i]);
        }
        for(int j = 0 ;j<nums2.length;j++){
            if(hashMap.containsKey(nums2[j])){
                hashMap1.put(nums2[j],nums2[j]);
            }
        }
        return hashMap1.keySet().stream().mapToInt(x->x).toArray();

    }
    public static String reverseWords(String s) {
        String[] sp = s.split(" ");
        int head = 0;
        int tail = sp.length-1;
        while (head<=tail){
            if(sp[head]!=" "&&sp[tail]!=" "){
                String temp = sp[head];
                sp[head] = sp[tail];
                sp[tail] = temp;
                head++;
                tail--;
            }
        }
        String reuslt = "";
        int size = sp.length;
        for(int i = 0 ;i<size;i++){
            reuslt+=sp[i];
            if(sp[i].length()>0){
                reuslt+=" ";
            }
        }
        return reuslt;

    }

    public static int removeElement(int[] nums, int val) {
        int size = nums.length;
        for(int i = 0 ;i<size;i++){
            if(nums[i]==val){
                for(int j = i+1;j<size;j++){
                    nums[j-1] = nums[j];
                }
                i--;
                size--;
            }
        }
        return size;
    }

}