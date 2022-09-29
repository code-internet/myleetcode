import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2022/8/22
 * Time: 16:32
 * Description:
 **/
public class StackArray {

    /**
     * 数组大小
     */
    int size ;
    int[] arr;

    public StackArray(){}
    public StackArray(int initSize){
        arr = new int[initSize];
        size = 0;
    }

    public Boolean isEmpty(){
        if(size<0){
            return true;
        }
        return false;
    }
    public Boolean isFull(){
        if(arr.length-1 == size){
            return true;
        }
        return false;
    }

    public void push(int val){
        if(isFull()){
            throw new RuntimeException("栈已满！");
        }
        arr[size] = val;
        size++;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空！");
        }
        int i = arr[size];
        size--;
        return i;
    }

    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("栈为空！");
        }
        return arr[size-1];
    }
}