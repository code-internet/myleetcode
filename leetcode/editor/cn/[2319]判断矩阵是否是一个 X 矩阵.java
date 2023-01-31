//如果一个正方形矩阵满足下述 全部 条件，则称之为一个 X 矩阵 ： 
//
// 
// 矩阵对角线上的所有元素都 不是 0 
// 矩阵中所有其他元素都是 0 
// 
//
// 给你一个大小为 n x n 的二维整数数组 grid ，表示一个正方形矩阵。如果 grid 是一个 X 矩阵 ，返回 true ；否则，返回 false 
//。 
//
// 
//
// 示例 1： 
// 输入：grid = [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]
//输出：true
//解释：矩阵如上图所示。
//X 矩阵应该满足：绿色元素（对角线上）都不是 0 ，红色元素都是 0 。
//因此，grid 是一个 X 矩阵。
// 
//
// 示例 2： 
// 输入：grid = [[5,7,0],[0,3,1],[0,5,0]]
//输出：false
//解释：矩阵如上图所示。
//X 矩阵应该满足：绿色元素（对角线上）都不是 0 ，红色元素都是 0 。
//因此，grid 不是一个 X 矩阵。
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 3 <= n <= 100 
// 0 <= grid[i][j] <= 10⁵ 
// 
//
// Related Topics 数组 矩阵 👍 34 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int sum = 0;
        int sum1 = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((i == j && grid[i][j] == 0)||(j == grid.length - i -1 && grid[i][j] ==0)){
                    return false;
                }
                if (i == j){
                    sum1 += grid[i][j];
                }
                if (j == grid.length - i -1){
                    sum1 += grid[i][j];
                }
                sum+=grid[i][j];
            }
        }
        if(grid.length%2!=0){
            sum1 = sum1-grid[(grid.length-1)/2][(grid.length-1)/2];
        }
        if(sum!=sum1){
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
