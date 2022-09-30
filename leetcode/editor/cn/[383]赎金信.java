//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 计数 👍 494 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine==null||ransomNote==null){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap();
        char[] chars = magazine.toCharArray();
        for(int i = 0 ;i<chars.length;i++){
            char temp = chars[i];
            map.put(temp,map.containsKey(temp)?map.get(temp)+1:1);
        }
        int count = 0;
        char[] charR = ransomNote.toCharArray();
        for(int j=0 ;j<charR.length;j++){
            if(map.containsKey(charR[j])){
                map.put(charR[j],map.get(charR[j])-1);
                if(map.get(charR[j])>=0){
                    count++;
                }
            }
        }
        return count==charR.length;
    }
    //方法二，运用26位字母
    public boolean canConstruct(String ransomNote, String magazine) {
        // 定义一个哈希映射数组
        int[] record = new int[26];

        // 遍历
        for(char c : magazine.toCharArray()){
            record[c - 'a'] += 1;
        }

        for(char c : ransomNote.toCharArray()){
            record[c - 'a'] -= 1;
        }

        // 如果数组中存在负数，说明ransomNote字符串总存在magazine中没有的字符
        for(int i : record){
            if(i < 0){
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
