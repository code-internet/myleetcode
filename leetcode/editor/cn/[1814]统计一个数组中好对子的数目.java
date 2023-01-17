//给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， 
//rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ： 
//
// 
// 0 <= i < j < nums.length 
// nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]) 
// 
//
// 请你返回好下标对的数目。由于结果可能会很大，请将结果对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [42,11,1,97]
//输出：2
//解释：两个坐标对为：
// - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
// - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
// 
//
// 示例 2： 
//
// 输入：nums = [13,10,35,24,76]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 数学 计数 👍 72 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countNicePairs(int[] nums) {
        int mod = (int)1e9 + 7;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            int number = nums[i];
            sum=(sum+map.getOrDefault(number-rev(number),0))%mod;
            map.put(number-rev(number),map.getOrDefault(number-rev(number),0)+1);
        }
        return sum;
    }

    public int rev(int x){
        int sum = 0;
        while (x!=0){
            int a=x%10;
            sum=sum*10+a;
            x=x/10;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
