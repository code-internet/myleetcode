import com.sun.deploy.util.ArrayUtil;

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

    public static int strStr(String haystack,String needle){
        return -1;
    }

    private static int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if(magazine==null||ransomNote==null){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap();
        char[] chars = magazine.toCharArray();
        for(int i = 0 ;i<chars.length;i++){
            char temp = chars[i];
            map.put(temp,map.containsKey(temp)?map.get(temp)+1:1);
        }
        int count = 0;
        char[] charR = ransomNote.toCharArray();
        for(int j=0 ;j<charR.length;j++){
            if(map.containsKey(charR[j])){
                map.put(charR[j],map.get(charR[j])-1);
                if(map.get(charR[j])>=0){
                    count++;
                }
            }
        }
        return count==charR.length;
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList arrayList = new ArrayList();
        for(int i = 0 ;i<nums.length;i++){
            int temp = nums[i];
            int head = i+1;
            int tail = nums.length-1;
            while (head<tail){
                if(nums[head]+nums[tail]==-temp){
                    ArrayList arrayList1 = new ArrayList();
                    arrayList1.add(nums[head]);
                    arrayList1.add(nums[tail]);
                    arrayList1.add(temp);
                    arrayList.add(arrayList1);
                    head++;
                    tail--;
                }else if(nums[head]+nums[tail]+temp>0){
                    tail--;
                }else if(nums[head]+nums[tail]+temp<0){
                    head++;
                }
            }
        }
        HashSet set = new HashSet(arrayList);
        arrayList.clear();
        arrayList.addAll(set);
        return arrayList;
    }


    public static ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }
        if(head.next==null&&head.val!=val){
            return head;
        }
        ListNode listNode = new ListNode(-1);
        ListNode listNode1 = listNode;
        while (head.next!=null){
            if(head.val != val){
                ListNode node = new ListNode(head.val);
                listNode.next = node;
                listNode = listNode.next;
            }
            head=head.next;
        }
        return listNode1.next;
    }

    public static ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode listNode = head;
        while (listNode!=null&&listNode.next!=null){
            int temp = listNode.val;
            listNode.val = listNode.next.val;
            listNode.next.val = temp;
            listNode = listNode.next.next;
        }
        return head;
    }
  


    public static void preOrderTraverse(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                System.out.print(pNode.val+" ");
                pNode = pNode.left;
            } else  {
                TreeNode node = stack.pop();
                pNode = node.right;

            }
        }
    }


    public static void midOrderTraverse(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else  {
                TreeNode node = stack.pop();
                pNode = node.right;
                System.out.print(node.val+" ");
            }
        }
    }

    /**
     * 非递归后序遍历
     * 后续遍历和先序、中序遍历不太一样。
     *
     * 后序遍历在决定是否可以输出当前节点的值的时候，需要考虑其左右子树是否都已经遍历完成。
     *
     * 所以需要设置一个lastVisit游标。
     *
     * 若lastVisit等于当前考查节点的右子树，表示该节点的左右子树都已经遍历完成，则可以输出当前节点。
     *
     * 并把lastVisit节点设置成当前节点，将当前游标节点node设置为空，下一轮就可以访问栈顶元素。
     *
     * 否者，需要接着考虑右子树，node = node.right。
     *
     * @param root
     */
    public static void aftOrderTraverse(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            //查看当前栈顶元素
            node = treeNodeStack.peek();
            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (node.right == null || node.right == lastVisit) {
                System.out.print(node.val + " ");
                treeNodeStack.pop();
                lastVisit = node;
                node = null;
            } else {
                //否则，继续遍历右子树
                node = node.right;
            }
        }
    }


    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depth = getDepth(root);
        return depth;
    }
    public static int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int i = getDepth(root.left);
        int k = getDepth(root.right);
        return Math.max(i,k)+1;
    }
    public static int minOperations(int[] nums) {
        int count = 0;
        if(nums.length == 1){
            return count;
        }
        for(int i = 0; i<nums.length-1;i++){
            while (nums[i]>=nums[i+1]){
                nums[i+1] = nums[i+1]+1;
                count+=1;
            }
        }
        return count;
    }

    public static int beautySum(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] cnt = new int[26];
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                cnt[s.charAt(j) - 'a']++;
                maxFreq = Math.max(maxFreq, cnt[s.charAt(j) - 'a']);
                int minFreq = s.length();
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0) {
                        minFreq = Math.min(minFreq, cnt[k]);
                    }
                }
                res += maxFreq - minFreq;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String  nums = "aabcb";
        checkIfPangram(nums);
    }

    public static boolean checkIfPangram(String sentence) {
        if(sentence.length()<26){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap();
        for(int i = 0;i<sentence.length();i++){
            int j =  map.get(sentence.charAt(i))==null?0:(Integer)map.get(sentence.charAt(i));
            map.put(sentence.charAt(i),j+1);
        }
        if(map.size()==26){
            return true;
        }
        return false;
    }


}
