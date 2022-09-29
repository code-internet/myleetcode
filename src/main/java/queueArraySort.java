import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2022/9/15
 * Time: 10:20
 * Description:
 **/
public class queueArraySort {
        // 存储数据的数组
        private Object[] arr;
        //队列大小
        private int size;
        // 默认队列容量
        private int DEFAULT_CAPACITY = 10;
        // 队列头指针
        private int head;
        // 队列尾指针
        private int tail;

        private int MAX_ARRAY_SIZE  = Integer.MAX_VALUE-8;

        /**
         * 默认构造函数 初始化大小为10的队列
         */
        public queueArraySort(){
            arr = new Object[DEFAULT_CAPACITY];
            initPointer(0,0);
        }

        /**
         * 通过传入的容量大小创建队列
         * @param capacity
         */
        public queueArraySort(int capacity){
            arr = new Object[capacity];
            initPointer(0,0);
        }

        /**
         * 初始化队列头尾指针
         * @param head
         * @param tail
         */
        private void initPointer(int head,int tail){
            this.head = head;
            this.tail = tail;
        }

        /**
         * 元素入队列
         * @param element
         * @return
         */
        public boolean enqueue(Object element){
            ensureCapacityHelper();
            //在尾指针处存入元素且尾指针后移
            arr[tail++] = element;
            size++;//队列元素个数加1
            return true;
        }

        /**
         * 出队列
         * @return
         */
        public Object dequeue(){
            if(head==tail){
                //队列中没有数据
                return null;
            }
            //取出队列头的元素且头指针后移
            Object obj=arr[head++];
            size--;//队列中元素个数减1
            return obj;
        }

    /**
     * 获取队列元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

        /**
        * 数组移动
        */
       private void ensureCapacityHelper() {
           //尾指针已越过数组尾端
           if(tail==arr.length){
               //判断队列是否已满 即判断数组中是否还有可用存储空间
               //tail  == arr.length 即尾指针指向末尾，head =0，头指针指向顶部，数组满。需要扩容操作
               if(head==0){
                   grow(arr.length);
               }else{
                   //进行数据搬移操作 将数组中的数据依次向前挪动直至顶部
                   for(int i= head;i<tail;i++){
                       arr[i-head]=arr[i];
                   }
                   //数据搬移完后重新初始化头尾指针
                   initPointer(0,tail-head);
               }
           }
       }
        /**
         * 扩容
         * @param oldCapacity 原始容量
         */
        private void grow(int oldCapacity) {
            int newCapacity = oldCapacity+(oldCapacity>>1);
            if(newCapacity>MAX_ARRAY_SIZE){
                newCapacity = Integer.MAX_VALUE;
            }
            arr = Arrays.copyOf(arr,newCapacity);
        }

}