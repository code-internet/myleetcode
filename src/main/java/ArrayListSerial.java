import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2023/9/18
 * Time: 10:33
 * Description:
 **/
public class ArrayListSerial {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<String> strings = new ArrayList<String>();
        strings.add("测");
        strings.add("测2");
        strings.add("测3");
        strings.add("测4");
        System.out.println("strings" + strings);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("strings"));   //序列化写入文件
        objectOutputStream.writeObject(strings);
        objectOutputStream.close();
        File file = new File("strings");
        System.out.println(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file)); //反序列化 从文件中读出来
        List<String> newStringList = (List<String>)objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("new strings" + strings);
    }


}