/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2022/8/22
 * Time: 18:00
 * Description:
 **/
public class ArrMaxValue {
    public static Integer getMax(int left,int right,int[] arr){
        int mid = left+((right-left)>>1);
        if(left == right){
            return arr[left];
        }
        int leftMax = getMax(left,mid,arr);
        int rightMax = getMax(mid+1,right,arr);
        return Math.max(leftMax,rightMax);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        Integer max = getMax(0, arr.length-1, arr);
        System.out.println(max);
    }
}