package base.test;

/**
 * Created by shichen.ma on 2017/8/21.
 */
public class test_exception extends Exception{
    public test_exception(String str){
        System.out.println(str);
    }
    public void test_out(){
        System.out.println("ceshi ");
    }
}
