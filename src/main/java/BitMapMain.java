import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2023/9/6
 * Time: 11:47
 * Description:
 **/
//bitmap 位图操作
public class BitMapMain {

    public static void main(String[] args) {
        //byte数组，就是除以8, int数组就是除以32
        byte[] bits = new byte[1000]; //数组大小, 根据要存的数据进行变动 n/8=1000, 即这里可以存8000个数
        byte[] arr = {0, 10, 8, 20, 33, 45, 23, 67, 102, 99};
        //初始化，保存数字
        for (int i = 0; i < arr.length; i++) {
            add(bits, arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("before clear，是否存在" + arr[i] + "值：" + contains(bits, arr[i]));
            if (arr[i] == 10 || arr[i] == 33) {
                //重置值
                clear(bits, arr[i]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("after clear，是否存在" + arr[i] + "值：" + contains(bits, arr[i]));
        }
        /*ArrayList<String> strings = new ArrayList<String>() {{
            add("ddd");
        }};
        List<String> strings1 = strings.subList(0, 1);*/
    }

    //添加
    public static void add(byte[] bits, int num) {
        bits[getIndex(num)] |= 1 << (getPosition(num));
        //10100100 -- bits[getIndex(num)]
        //00010000 -- 1左移, |或操作
        //10110100 -- bits[getIndex(num)]重新赋值
    }

    //重置
    public static void clear(byte[] bits, int num) {
        bits[getIndex(num)] &= ~(1 << getPosition(num));
        //10110100 -- bits[getIndex(num)]是添加后的新值
        //11101111 -- 1左移00010000, ~取反11101111， & 与操作
        //10100100 -- bits[getIndex(num)]
    }

    //值是否存在
    public static boolean contains(byte[] bits, int num) {
        return (bits[getIndex(num)] & 1 << getPosition(num)) != 0;
        //10110100 -- bits[getIndex(num)]是添加后的新值
        //00010000 -- 1左移，& 与操作
        //00010000 -- bits[getIndex(num)]，如果有一个二进制位是1，则说明值存在
    }

    /**
     * 计算位于数组的下标, 例如14/8=1,处于bits[1]
     **/
    private static int getIndex(int num) {
        /*
        return num / 8 ;
        */
        return num >> 3;
    }

    /**
     * 计算处于二进制中的第几位（得到的下标，从0开始）
     * 14%8=6, 所以下标是6, 处于第7个位置 01000000
     **/
    private static int getPosition(int num) {
        return num % 8;
    }
}