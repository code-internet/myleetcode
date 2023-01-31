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
        int[][] grid = {{2,0,0,0,1},{0,4,0,1,5},{0,0,5,0,0},{0,5,0,2,0},{4,0,0,0,2}};
        boolean i = checkXMatrix(grid);
        System.out.println(i);
    }

    public static boolean checkXMatrix(int[][] grid) {
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
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sum+=grid[i][j];
            }
        }
        if(grid.length%2!=0){
            sum1 = sum1-grid[(grid.length-1)/2][(grid.length-1)/2];
        }
        System.out.println(sum);
        System.out.println(sum1);
        if(sum!=sum1){
            return false;
        }
        return true;
    }

}
