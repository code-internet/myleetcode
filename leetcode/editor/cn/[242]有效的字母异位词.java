//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//
// Related Topics 哈希表 字符串 排序 👍 668 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if((s==null&&t!=null) || (s!=null&&t==null) ){
            return false;
        }
        HashMap<Object,Integer> map1 = new HashMap();
        HashMap<Object,Integer> map2 = new HashMap();
        char[] chars1 = s.toCharArray();
        for(char c : chars1){
            map1.put(c,map1.containsKey(c) ? map1.get(c)+1:1);
        }
        char[] chars2 = t.toCharArray();
        for(char c : chars2){
            map2.put(c,map2.containsKey(c) ? map2.get(c)+1:1);
        }
        if(map1.equals(map2)){
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
