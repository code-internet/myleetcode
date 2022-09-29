import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2022/8/30
 * Time: 10:24
 * Description:
 **/
public class SelectionSort {
    public static void sort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        // i ~ N-1
        for(int i= 0 ;i<arr.length;i++){
            // 最小值在哪个位置上  i～n-1
            int minIndex = i;
            // i ~ N-1 上找最小值的下标
            for(int j = i+1 ;j<arr.length;j++){
                if(arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            swap(arr,minIndex,i);
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