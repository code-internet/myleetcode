/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2022/9/16
 * Time: 10:21
 * Description:
 **/
public class queueArrayLoop {
    //存储队列数据的数组
    private Object[] arr;
    //默认数组容量
    private int DEFAULT_CAPACITY=10;
    // 队列头指针
    private int head;
    //队列尾指针
    private int tail;

    /**
     * 默认构造函数
     */
    public queueArrayLoop(){
        arr = new Object[DEFAULT_CAPACITY];
    }

    /**
     * 通过传入的容量参数构造队列
     * @param capacity
     */
    public queueArrayLoop(int capacity){
        arr = new Object[capacity];
    }

    /**
     * 元素入队列
     * @param element
     * @return
     */
    public boolean enqueue(Object element){
        //判断队列是否已满
        if(head == (tail+1)%arr.length){
            //队列已满
            return false;
        }
        //将元素存入tail位置上
        arr[tail]=element;
        //尾指针后移
        /*tail++;
        if(tail==arr.length){
            tail = 0;
        }*/
        tail = (tail+1)%arr.length;
        return true;
    }

    /**
     * 元素出队列
     * @return
     */
    public Object dequeue(){
        //判断队列是否为空
        if(head==tail){
            return null;
        }
        //获取head位置上的元素
        Object element = arr[head];
        //头指针后移
        /*head++;
        if(head==arr.length){
            head = 0;
        }*/
        head = (head+1)%arr.length;
        return element;
    }

    /**
     * 循环数组有效长度
     * @return
     */
    public int getActiveLength(){
        return (tail-head+arr.length)%arr.length;
    }
}