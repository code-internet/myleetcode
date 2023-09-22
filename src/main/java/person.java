import java.util.*;

public class person implements Comparable<person>{

    String name;
    int age;
    String gender;
    //构造代码块
    {
        System.out.println("构造代码块。。。");
    }

    person() {
        System.out.println("无参构造");
    }

    person(String n, int a, String g) {
        name = n;
        age = a;
        gender = g;
        System.out.println("有参构造");
    }

    void run() {
        System.out.println("普通方法...");
    }

    @Override
    public int compareTo(person o) {
        int flag = this.name.compareTo(o.name);
        return 0;
    }
}

class demo {
    public static void main(String[] args) {

    }
}