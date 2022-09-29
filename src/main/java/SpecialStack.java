import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2022/8/22
 * Time: 17:42
 * Description:.实现特殊栈，返回最小值。
 **/


public class SpecialStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int val){
        if(stack.empty()&&min.empty()){
            stack.push(val);
            min.push(val);
        }else {
            stack.push(val);
            min.push(min.peek()>val?val:min.peek());
        }
    }
    public Integer pop(){
        Integer pop = stack.pop();
        min.pop();
        return pop;
    }
    public Integer getMin(){
        return min.peek();
    }

    public static void main(String[] args) {
        SpecialStack specialStack = new SpecialStack();
        specialStack.push(1);
        specialStack.push(-9);
        specialStack.push(0);
        specialStack.push(-1);
        System.out.println(specialStack.getMin());
    }
}
