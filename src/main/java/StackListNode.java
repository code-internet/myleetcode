/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2022/8/22
 * Time: 15:17
 * Description:
 **/
public class StackListNode {

    /**
     * 栈顶元素
     */
    ListNode node ;
    /**
     * 栈内元素个数
     */
    int elementCount;
    /**
     * 栈的空间大小
     */
    int size;

    /**无参构造*/
    public StackListNode(){
        node = new ListNode(-1);
        elementCount = 0;
        size = 0;
    }

    /**
     * 构造方法设置栈的空间大小
     * @param size
     */
    public StackListNode(int val ,int size){
        node = new ListNode(val);
        elementCount = 0;
        this.size = size;
    }

    /**
     * 判断栈是否满员
     * @return
     */
    public Boolean isFull(){
        if(size == elementCount){
            return true;
        }
        return false;
    }

    /**
     * 判断栈是否为空
     * 判断栈值的个数
     * @return
     */
    public Boolean isEmpty(){
        if(elementCount==0){
            return true;
        }
        return false;
    }

    public void push(int value){
        if(isFull()){
            throw new RuntimeException("Stack is Full");
        }
        ListNode val = new ListNode(value);
        ListNode temp = node;//临时节点指向链表节点。
        node =val;//node指向新节点节点。
        node.next = temp;//最新数据（也就是头结点)指向temp节点，头插法
        elementCount++;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        int i = node.val;
        node = node.next;
        elementCount--;
        return i;
    }

    public int peek(){
        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return node.val;
    }

}