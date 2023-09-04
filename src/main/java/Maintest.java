import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2022/8/15
 * Time: 17:29
 * Description:
 **/
public class Maintest {

    public static void main(String[] args) {
        /*Store maintest = new Store();
        maintest.setName("小鱼儿");
        Apple apple = new Apple();
        apple.setPrice(new BigDecimal(0.5));
        maintest.setFruit(apple);
        String s = JSON.toJSONString(maintest, SerializerFeature.WriteClassName);
        System.out.println("序列化后结果："+s);

        Store store = JSON.parseObject(s, Store.class);
        System.out.println("反序列花后结果："+store);

        Apple newApple = (Apple)store.getFruit();
        System.out.println("apple反序列化结果："+newApple);
*/

        User hollis = new User();
        hollis.setName( "Hollis");
        hollis.setGender("Male");
        pass(hollis);
        System.out.println( "print in main , user is " + JSON.toJSONString(hollis));

    }

    public static void pass(User user) {

        user.setName( "hollischuang");
        System.out.println( "print in pass , user is " + JSON.toJSONString(user));
    }




}

class User{
    private String name;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}


class Store{
    private String name;
    private Fruit fruit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }
}

interface Fruit{}

class Apple implements Fruit{
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}


