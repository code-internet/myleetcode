import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2022/8/30
 * Time: 11:14
 * Description:
 **/
public class InsertSort {


    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0~0 有序的
        // 0~1 有序的
        //.....
        // 0~i 想有序
        for (int i = 1; i < arr.length; i++) { // 0 ~ i 做到有序
            // arr[i]往前看，一直交换到合适的位置停止
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    // i和j是一个位置的话，会出错
    /*证明：
    假设arr[i] = a;
    arr[j]=b;
    arr[i] = a^b;
    arr[j] = a^b^b; ->a
    arr[i] = a^b^a; ->b*/
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
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