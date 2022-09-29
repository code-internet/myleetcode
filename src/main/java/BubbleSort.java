import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2022/8/30
 * Time: 10:50
 * Description:
 **/
public class BubbleSort {

    public static void sort(int[] arr){
        //在arr[0～N-1]范围上：
        for(int i = arr.length-1;i>0;i--){
            //arr[0]和arr[1]，谁大谁来到1位置；arr[1]和arr[2]，谁大谁来到2位置…arr[N-2]和arr[N-1]，谁大谁来到N-1位置
            for(int j = 0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,i,j);
                }
            }
        }
    }
    public static void swap(int[] arr ,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {1,3,45,6,7,8,34,56,6,32,566};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("===================");

        int[] arr1 = {1,3,45,6,7,8,34,56,6,32,566};
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}