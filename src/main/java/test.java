import com.sun.org.apache.regexp.internal.RE;

import java.util.*;
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
       int[] nums = {13,10,35,24,76};
        int i = countNicePairs(nums);
        System.out.println(i);
    }

    public static int countNicePairs(int[] nums) {
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
    public static int rev(int x){
        int sum = 0;
        while (x!=0){
            int a=x%10;
            sum=sum*10+a;
            x=x/10;
        }
        return sum;
    }

}
