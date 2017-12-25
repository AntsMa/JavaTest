package base.test;

import java.lang.reflect.Method;

/**
 * Created by shichen.ma on 2017/8/21.
 */
public abstract class test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        System.out.println(TestInterface.age);
        System.out.println(TestInterface.name);
        System.out.println(TestInterface.class_);
        System.out.println(TestInterface.sex);
        try {
            throw new Exception ("ssss");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            throw new test_exception("shuchu");
        } catch (base.test.test_exception test_exception) {
            test_exception.printStackTrace();
        }

        Class c = null;
        try {
            c = Class.forName("base.test.sf_class");
            System.out.println("try");
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("finally");
        }
        Object obj = c.newInstance();
         Method[] method = c.getMethods();
        for (int i = 0; i < method.length; i++) {
            System.out.println(      method[i].getDeclaredAnnotations());
        }
    }


}
