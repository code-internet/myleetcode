import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2022/8/1
 * Time: 14:27
 * Description:
 **/
public class ListNode_test1 {

        public static void main(String[] args) {
            boolean h3 = squareIsWhite("a2");
            System.out.println(h3);
        }

    public static boolean squareIsWhite(String coordinates) {
        char[] chars = coordinates.toCharArray();
        System.out.println(chars[0]+chars[1]);
        return (chars[0] + chars[1]) % 2 == 1;
    }

}