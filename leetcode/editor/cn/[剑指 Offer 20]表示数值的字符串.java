//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。 
//
// 数值（按顺序）可以分成以下几个部分： 
//
// 
// 若干空格 
// 一个 小数 或者 整数 
// （可选）一个 'e' 或 'E' ，后面跟着一个 整数 
// 若干空格 
// 
//
// 小数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 下述格式之一： 
// 
// 至少一位数字，后面跟着一个点 '.' 
// 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字 
// 一个点 '.' ，后面跟着至少一位数字 
// 
// 
//
// 整数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 至少一位数字 
// 
//
// 部分数值列举如下： 
//
// 
// ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"] 
// 
//
// 部分非数值列举如下： 
//
// 
// ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"] 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "e"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s = "."
//输出：false 
//
// 示例 4： 
//
// 
//输入：s = "    .1  "
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。 
// 
//
// Related Topics 字符串 👍 365 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNumber(String s) {
                if(s.length() == 0 || (" ").equals(s)) return false;
                boolean numFlag = false; // 标记数字
                boolean dotFlog = false; // 标记点
                boolean eFlag = false; // 标记e或E
                s = s.strip(); // 去掉空格符

                for(int i = 0; i < s.length(); i++) {
                    char temp = s.charAt(i);
                    // 判定为数字，numFlag = true
                    if(temp >= '0' && temp <= '9') {
                        numFlag = true;
                    }
                    // 判定为"."，需要没有出现过，并且没有出现过e
                    else if(temp == '.' && !dotFlog && !eFlag) {
                        dotFlog = true;
                    }
                    // 判定为e,需要没出现过E,并且出现过数字
                    else if((temp == 'e' || temp == 'E') && !eFlag && numFlag) {
                        eFlag = true;
                        numFlag = false; // 出现e后就标记为false
                    }
                    // 判定为+/-符号，只能出现在第一位或者紧接e后面
                    else if((temp == '+' || temp == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {

                    }
                    // 其他情况都是非法的
                    else {
                        return false;
                    }
                }
                return numFlag;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
