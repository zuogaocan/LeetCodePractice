
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {
    //五种类的创建方式
    void creatClass() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, CloneNotSupportedException, IOException, ClassNotFoundException {
        //1 通过new关键字
        Main main1 = new Main();
        //2 Class.class.newInstance()
        Main main2 = Main.class.newInstance();
        //3 constructer
        Main main3 = Main.class.getConstructor().newInstance();
        //4
        Main main4 = (Main) main1.clone();
        //5
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));
        out.writeObject(main1);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(out.toString()));
        Main main5 = (Main)in.readObject();
    }

    //交换两个实参的值 传入a=1，b=0;
    void swap(Integer a,Integer b)  {
        int temp = b.intValue();
        Field value = null;
        try {
            value = Integer.class.getDeclaredField("value");
            value.setAccessible(true);
            value.set(b,a);
            value.set(a,new Integer(temp));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public void test1() {
        Integer a = 1, b = 0;
        swap(a, b);
        System.out.println(a);
        System.out.println(b);
    }
    @Test
    public void testJackson(){
        //反序列化
//        String str = "{\n"+
//            " \"name\":\"zuogaocan\",\n"+
//            " \"age\":\"18\",\n"+
//            " \"type\":\"student\"\n"+
//                "}";
//        ObjectMapper mapper = new ObjectMapper();
//        System.out.println(str);
//        try {
//            User user = mapper.readValue(str, User.class);
//            System.out.println(user);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
        User user = new User();
        user.setAge(11).setType("student").setName("zuogaocan");
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(user));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

