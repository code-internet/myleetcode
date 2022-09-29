/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2022/9/9
 * Time: 14:39
 * Description:循环队列
 **/
public class queueArray {

    //队头，指向队头前一个位置
    private int front;
    //队尾，指向队尾位置
    private int rear;
    //储存位置
    private Object[] arr;

    public Object[] getArr() {
        return arr;
    }

    public void setArr(Object[] arr) {
        this.arr = arr;
    }

    public queueArray() {
    }


    //初始化，length 需要开辟数组的长度
    public queueArray(int length) {
        this.arr = new Object[length];
    }

    //判断队列是否满
    public boolean isFull() {
        int maxSize = arr.length;
        //从1开始添加队列，如果数组长度是6，添加5个队列便为满状态，（5+1）%6=0=front
        return ((rear + 1) % maxSize == front);

    }

    //判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }
    //入队
    public void add(Object data) {
        if (isFull()) {
            System.out.println("该队列已经满了");
        } else {
            rear = (rear + 1) % arr.length;
            arr[rear] = data;
            System.out.println("入队元素为" + data);
        }
    }
    //出队
    public void poll() {
        if (isEmpty()) {
            System.out.println("这是一个空队列");
        } else {
            front = (front + 1) % arr.length;
            Object data = arr[front];
            arr[front] = null;
            System.out.println("出队元素为" + data);
        }
    }

}