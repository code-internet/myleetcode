//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 477 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr==null){
            return arr;
        }
        int[] arr_  = new int[k];
        QuickSort(arr);
        for(int i = 0;i<arr.length;i++){
            if (i < k){
                arr_[i] = arr[i];
            }
        }
        return arr_;
    }

    public void QuickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        QuickSort(arr, 0, arr.length - 1);
    }

    private void QuickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] part = partiton(arr, l, r);
            QuickSort(arr, l, part[0] - 1);
            QuickSort(arr, part[1] + 1, r);
        }
    }
    private int[] partiton(int[] arr, int l, int r) {
        int s = l - 1;
        int b = r;
        while (l < b) {
            if (arr[l] < arr[r]) {
                swap(arr, ++s, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --b, l);
            } else {
                l++;
            }
        }
        swap(arr, b, r);
        return new int[]{s + 1, b};
    }
    public void swap(int[] arr,int L ,int R){
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
