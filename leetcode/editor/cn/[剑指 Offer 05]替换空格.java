//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
//
// Related Topics 字符串 👍 354 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ;i<chars.length;i++){
            if(chars[i]==' '){
                sb.append("%20");
            }else {
                sb.append(chars[i]);
            }
        }
        return  new String(sb);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
