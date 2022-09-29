/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2022/9/16
 * Time: 14:30
 * Description:
 **/



public class queueMyLink {
    private Node front;
    private Node rear;
    private int size;

    public queueMyLink() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    public void add(Object data) {
        //有新元素入队列，创建一个相应的结点对象，申请空间
        Node node = new Node(data);
        //如果是添加的第一个队列，将其设置为头结点
        if(size == 0) {
            front = node;
        }else { //否则将尾结点的下一个结点更新为新结点
            rear.next = node;
        }
        //更新rear
        rear = node;
        //更新size
        size += 1;
        System.out.println("入队元素为" + node.date);
    }
    public void pull() {
        if(size == 0) {
            System.out.println("这是一个空队列");
            rear = null;
        }else {
            Object data = front.date;
            front = front.next;
            System.out.println("出队元素为" + data);
            size -= 1;
        }
    }



}