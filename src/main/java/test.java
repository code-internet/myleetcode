import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2022/8/15
 * Time: 17:29
 * Description:
 **/
public class test {


    public static void main(String[] args) {
        String s = "abccbaacz";
        char b = repeatedCharacter1(s);
        System.out.println(b);

    }

    public static char repeatedCharacter(String s) {
        HashMap<Character,Integer> map = new HashMap();
        for(int i = 0 ;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            if(map.get(s.charAt(i))>=2){
                return s.charAt(i);
            }
        }
        return ' ';
    }
    public static char repeatedCharacter1(String s) {
        int[] a = new int[26];
        for(int i = 0 ;i<s.length();i++){
            if(a[s.charAt(i)-'a']==1){
                return s.charAt(i);
            }
            a[s.charAt(i)-'a'] = 1;
        }
        return ' ';
    }






}
