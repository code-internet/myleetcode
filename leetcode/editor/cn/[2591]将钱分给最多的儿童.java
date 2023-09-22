//给你一个整数 money ，表示你总共有的钱数（单位为美元）和另一个整数 children ，表示你要将钱分配给多少个儿童。 
//
// 你需要按照如下规则分配： 
//
// 
// 所有的钱都必须被分配。 
// 每个儿童至少获得 1 美元。 
// 没有人获得 4 美元。 
// 
//
// 请你按照上述规则分配金钱，并返回 最多 有多少个儿童获得 恰好 8 美元。如果没有任何分配方案，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：money = 20, children = 3
//输出：1
//解释：
//最多获得 8 美元的儿童数为 1 。一种分配方案为：
//- 给第一个儿童分配 8 美元。
//- 给第二个儿童分配 9 美元。
//- 给第三个儿童分配 3 美元。
//没有分配方案能让获得 8 美元的儿童数超过 1 。
// 
//
// 示例 2： 
//
// 输入：money = 16, children = 2
//输出：2
//解释：每个儿童都可以获得 8 美元。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= money <= 200 
// 2 <= children <= 30 
// 
//
// Related Topics 贪心 数学 👍 73 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int distMoney(int money, int children) {
        if(money<children){
            return -1;
        }
        //保证没个人分配到1美金。然后处理剩余的钱
        money = money - children;
        //如果刚好每人分七块钱，就是最大满足每人分8块。那么就取最小值。
        //这个最小值就是每个人分配到8块钱最大数  最多有多少个儿童获得 恰好 8 美元
        int ans = Math.min(money/7,children);
        //计算正常 分配最多有多少个儿童获得 恰好 8 美元 后，还剩余的钱。
        money = money - ans*7;
        // 分配最多儿童获取8美元还有没有儿童剩余。
        children = children - ans;
        //分情况考虑问题。还有富裕钱，但是没有儿童了，8美元刚好的就要减去一个。给这多余钱分给这个儿童。
        if(money>0 && children == 0){
            ans--;
        }
        //若果还有一个儿童，为什么不能是三，因为 题目要求不能等于 4  所以 1 个儿童，而且还有 3块钱。就减去 一个分配 8美元的人 ，那么就空出2个儿童。2个儿童随机分配这剩余钱。
        if(money == 3 && children ==1){
            ans--;
        }
        return ans ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
