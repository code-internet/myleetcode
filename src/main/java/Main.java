import com.alibaba.fastjson.JSON;

import java.math.BigInteger;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2023/9/1
 * Time: 16:23
 * Description:
 **/
public class Main {

    public static void main(String[] args) {
        int[] cardPoints = {9,7,7,9,7,7,9};
        long i = maxScore(cardPoints,7);
        System.out.println(JSON.toJSONString(i));

    }

    public static int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length;
        for(int i = 0 ;i<n;i++){
            sum+=cardPoints[i];
        }
        if(k==n){
            return sum;
        }
        int kk = n-k;
        int ans = 999999999;
        int min_res= 0;
        for(int i=0;i<n;i++){
            min_res+=cardPoints[i];
            if(i<kk-1){
                continue;
            }
            ans = Math.min(min_res,ans);
            min_res-=cardPoints[i-kk+1];
        }
        return sum-ans;
    }


    public static long maxSum(List<Integer> nums, int m, int k) {
        long ans = 0;
        long temp = 0 ;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.size() ; i++){
            temp+=(long) nums.get(i);
            map.put(nums.get(i),map.getOrDefault(nums.get(i),0)+1);
            if(i<k-1){
                continue;
            }
            if(map.size()>=m){
                ans = Math.max(ans,temp);
            }
            temp-=(long)nums.get(i-k+1);
            if(map.get(nums.get(i-k+1))>1){
                map.put(nums.get(i-k+1),map.getOrDefault(nums.get(i-k+1),0)-1);
            }else {
                map.remove(nums.get(i-k+1));
            }
        }
        return ans;
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;
        int N = grumpy.length;
        for(int i= 0 ; i<N;i++){
            if(grumpy[i]==0){
                sum+=customers[i];
            }
        }
        int temp = 0;
        for(int i = 0; i<minutes; i++){
            temp+=customers[i]*grumpy[i];
        }
        int Maxtemp = temp;
        for(int i=minutes;i<N;i++){
            temp=temp+customers[i]*grumpy[i]-customers[i-minutes]*grumpy[i-minutes];
            Maxtemp = Math.max(Maxtemp, temp);
        }
        return sum+Maxtemp;
    }

    ///输入：code = [5,7,1,4], k = 3
    ////输出：[12,10,16,13]
    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if(k==0)
            return ans;
        int r=k>0?k+1:n;
        k=Math.abs(k);
        int s = 0;
        for(int i = r-k;i<r;i++){
            s+=code[i];
        }
        for(int i= 0 ;i<n;i++){
            ans[i]=s;
            s+=code[r%n]-code[(r-k)%n];
            r++;
        }
        return ans;
    }

    public static int minimumRecolors(String blocks, int k) {
        char[] chars = blocks.toCharArray();
        int ans = 999;
        int w = 0 ;
        for(int i = 0 ;i<chars.length;i++){
            if(chars[i]=='W'){
                w++;
            }
            if(i<k-1){
                continue;
            }
            ans = Math.min(w,ans);
            if(chars[i-k+1]=='W'){
                w--;
            }
        }
        return ans;
    }
    public static int[] getAverages(int[] nums, int k) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr,-1);
        BigInteger sum = new BigInteger("0");
        for(int i = 0 ;i<nums.length;i++){
            sum=sum.add(new BigInteger(nums[i]+""));
            if(i<2*k){
                continue;
            }
            arr[i-k] =sum.divide(new BigInteger((2*k+1)+"")).intValue();
            sum=sum.subtract(new BigInteger(nums[i-2*k]+""));
        }
        return arr;
    }

    public static double findMaxAverage(int[] nums, int k) {
        int sum = -999999999;
        int temp = 0;
        for (int i=0;i<nums.length;i++){
            temp+=nums[i];
            if(i<k-1){
                continue;
            }
            sum = Math.max(sum,temp);
            temp=temp-nums[i-k+1];
        }
        return (double)sum/k;
    }

    public static int maxVowels(String S, int k) {
        char[] s = S.toCharArray();
        int ans = 0;
        int vowel = 0;
        for (int i = 0; i < s.length; i++) {
            // 1. 进入窗口
            if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
                vowel++;
            }
            if (i < k - 1) { // 窗口大小不足 k
                continue;
            }
            // 2. 更新答案
            ans = Math.max(ans, vowel);
            // 3. 离开窗口
            char out = s[i - k + 1];
            if (out == 'a' || out == 'e' || out == 'i' || out == 'o' || out == 'u') {
                vowel--;
            }
        }
        return ans;
    }

    public static int maxScore(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 1; i < n; i++) {
            int score = 0;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == '0') {
                    score++;
                }
            }
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '1') {
                    score++;
                }
            }
            ans = Math.max(ans, score);
        }
        return ans;
    }

    public static int[] shuffle(int[] nums, int n) {
        int temp = n;
        int[] tempNums = new int[nums.length];
        int ii = 0;
        for(int i= 0 ;i<n;i++){
            tempNums[ii]=nums[i];
            tempNums[ii+1] = nums[nums.length-temp];
            temp--;
            ii=ii+2;
        }
        return tempNums;
    }

    public static boolean isPowerOfTwo(int n) {
        long ans = 1;
        long temp = n;
        while (temp>0){
            ans *= 3;
            temp--;
            if(ans==n){
                return true;
            }
            if(ans>n){
                return false;
            }
        }
        return false;
    }

    public static int subtractProductAndSum(int n) {
        String str = String.valueOf(n);
        int sum = 0 ;
        int sub = 1;
        char[] chars = str.toCharArray();
        for (int i= 0 ;i<chars.length;i++) {
            int ans = Integer.parseInt(String.valueOf(chars[i]));
            sum+=ans;
            sub*=ans;
        }
        return sub-sum;
    }
    public static String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++) {
            if(chars[i]>'A' && chars[i]<='Z'){
                chars[i]=(char) (chars[i]-'A'+'a');
            }
        }
        return new String(chars);
    }

    public static int minChanges(int n, int k) {
        String nn = Integer.toBinaryString(n);
        String kk = Integer.toBinaryString(k);
        if(nn.length()>kk.length()){
            for(int i= 0 ;i<nn.length()-kk.length();i++){
                kk = "0"+kk;
            }
        }else if(nn.length()<kk.length()){
            for(int i= 0 ;i<kk.length()-nn.length();i++){
                nn = "0"+nn;
            }
        }
         int ans = 0;
        Boolean flag = false;
        for(int i = 0 ;i<nn.length();i++){
            if(nn.charAt(i)==kk.charAt(i)){
                continue;
            }else if(nn.charAt(i)=='1' && kk.charAt(i)=='0'){
                ans++;
            }else {
                flag = true;
                break;
            }
        }
        if(flag){
            return -1;
        }
        return ans;
    }


    public static void test(String s1,String s2){
        if((s2+s2).contains(s1)){
            System.out.println(s2+s2);
        }else{
            System.out.println(s1);
        }
    }

    public static void rotate(int[][] matrix) {
        int[][] result=new int[matrix.length][matrix.length];
        for(int i=0; i<matrix.length;i++){
            for(int j =0;j<matrix[i].length;j++){
                result[i][j]=matrix[matrix.length-1-j][i];
            }
        }
        System.out.println(JSON.toJSONString(result));
    }

    public static void rotate1(int[][] matrix) {
            if (matrix.length == 0 || matrix.length != matrix[0].length) {
                return;
            }
            int n = matrix.length;
            for (int i = 0; i < n / 2; i++) { // 当前层
                // 当前层长度
                int last = n - 1 - i;
                for (int j = i; j < last; j++) {
                    // 当前层第几个元素
                    int offset = j - i;
                    // 存储上边(第i层第j列)
                    int top = matrix[i][j];
                    // 从左边(当前层即为最左边元素的列，行为当前层从下往上数第offset个)移到上边
                    matrix[i][j] = matrix[last - offset][i];
                    // 下边(当前层最后一行，第last -offset列)移到左边
                    matrix[last - offset][i] = matrix[last][last - offset];
                    // 右边移到下边
                    matrix[last][last - offset] = matrix[j][last];
                    // 上边移到右边
                    matrix[j][last] = top;
                }
            }
        System.out.println(JSON.toJSONString(matrix));
    }

    public static String compressString(String S) {
        if(S.length()==0)return S;
        int n = S.length();
        int i = 0 ;int j = 1;
        int count = 1;
        String str = "";
        while (j<n ){
            if(S.charAt(i) == S.charAt(j)){
                count++;
                j++;
            }else {
                str+=String.valueOf(S.charAt(i))+count;
                count=1;
                i=j;
                j++;
            }
        }
        str+=String.valueOf(S.charAt(i))+count;
        System.out.println(str);
        return str.length()<=n?str:S;
    }

    public static void removeDuplicateNodes(Node head) {
        Set set = new HashSet<>();
        Node cur = head;
        while (cur!=null && cur.next!=null){
            set.add(cur.date);
            if(set.contains(cur.next.date)){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        System.out.println(JSON.toJSONString(head));
    }

    public static int kthToLast(Node head, int k) {
        Node cur = head;
        Node cur1 = head;
        int count = 1;
        while (cur!=null && cur.next!=null){
            cur= cur.next;
            count++;
        }
        int tm = count-k;
        for(int i=0 ;i<tm;i++){
            cur1 = cur1.next;
        }
        return (int)cur1.date;
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0), big = new ListNode(0);
        ListNode smallHead = small, bigHead = big;
        while(head != null){
            // 判断值以决定加入small/big链表
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        // 尾结点
        big.next = null;
        // 小值链表接大值链表
        small.next = bigHead.next;
        return smallHead.next;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //进位标志
        int carry = 0;
        //开头的节点
        ListNode head = null;
        //指向上一个节点
        ListNode last = null;
        while (l1 != null || l2 != null){
            int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            //该位置上的数
            int cur = val + carry;
            Integer remainder = null;
            if ((cur / 10) > 0) {
                //有进位 余数
                remainder = cur % 10;
            }
            //求和之后的新节点
            ListNode newNode = new ListNode(remainder != null ? remainder : cur);
            if (head == null) {
                //一开始的头节点
                head = newNode;
            } else {
                last.next = newNode;
            }
            last = newNode;
            //存储进位信息 给下一次相加使用
            carry = cur / 10;
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }
        //循环结束了如果carry还有值，说明最后还进了一位，再增加一个节点
        if (carry == 1) {
            last.next = new ListNode(carry);
        }
        return head;

    }
    // 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
    //输出：2 -> 1 -> 9，即912
    public static void ListNode1() {
        ListNode node1 = new ListNode(7);
        node1.next = new ListNode(1);
        node1.next.next = new ListNode(6);


        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(9);
        node2.next.next = new ListNode(2);
        addTwoNumbers(node1,node2);
    }

    public static ListNode reverseList1(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode listNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head.next;
        head.next = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }
        return head;
    }


    public static int findMaxConsecutiveOnes(int[] nums) {
        // 最后一个 0 所在的索引位置
        int lastZero = -1;
        int ans = 0;
        for(int i = 0 ;i<nums.length;i++){
            if(nums[i]==0){
                lastZero = i;
            }else {
                ans = Math.max(ans,i-lastZero);
            }
        }
        return ans;
    }



}