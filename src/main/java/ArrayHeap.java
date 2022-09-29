import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2022/8/29
 * Time: 14:51
 * Description: 堆数据结构
 **/
public class ArrayHeap {

    static class MaxHeap{
        public int[] heap;
        public int limit;
        public int heapSize;


        MaxHeap(int limit){
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }

        public void push(int value){
            if(heapSize==limit){
                System.out.println("堆满");
            }
            heap[heapSize] = value;
            heapInsert(heap,heapSize);
            heapSize++;
        }

        //新加进来的数，现在停在了index位置，请依次往上移动
        private void heapInsert(int[] arr,int index){
            //当前节点的数值，和它的父节点，相比较，父节点位子(i-1)/2
            //当当前节点比父节点大，交换位子。
            while (arr[index] > arr[(index-1)/2]){
                swap(arr,index,(index-1)/2);
                index = (index-1)/2;
            }
        }

        //某个数在index位置，能否向下移动
        private void heapify(int[] arr, int index, int heapSize){
            int left = index * 2 + 1;//左孩子的下标
            while(left < heapSize){//下方还有孩子时
                //两个孩子中，谁的值大，把下表给largest
                //left + 1 右孩子，判断右孩子不越界，
                //arr[left + 1] > arr[left] 判断左右孩子 ，谁大，给下标给largest
                int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
                //父和孩子之间，谁的值大，把下标给largest
                largest = arr[largest] > arr[index] ? largest : index;
                if(largest == index){
                    break;
                }
                swap(arr, largest, index);
                index = largest;
                left = index * 2 + 1;
            }
        }

        public void heapSort(int[] arr) {
            if (null == arr || arr.length < 2) {
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                heapInsert(arr, i);
            }
            int heapSize = arr.length;
            //数组arr经过heapInsert，已经是大跟堆，最后一位和第一位交换，heapSize--，改变大小。
            swap(arr, 0, --heapSize);
            while (heapSize > 0) {
                //将改变后的数据，改变成大跟堆
                heapify(arr, 0, heapSize);
                //再次交换，堆顶最大值，和最后一位相互交换。while循环，直到headSize小与0，排序完成
                swap(arr, 0, --heapSize);
            }
        }


        public void swap(int[] arr,int i,int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr ={2, 4, 5, 6, 8, 6, 4, 0, 0, 0};
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }


}