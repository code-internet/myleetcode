//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 631 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hashMap = new HashMap();
        HashMap<Integer,Integer> hashMap1 = new HashMap();
        for(int i = 0;i<nums1.length;i++){
            hashMap.put(nums1[i],nums1[i]);
        }
        for(int j = 0 ;j<nums2.length;j++){
            if(hashMap.containsKey(nums2[j])){
                hashMap1.put(nums2[j],nums2[j]);
            }
        }
        hashMap1.setKey().s
        int a = hashMap1.size();
        int[] arr = new int[a];
        for (Integer s : hashMap1.keySet()) {
            arr[--a] = s;
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
