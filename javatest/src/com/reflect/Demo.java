package com.reflect;


        import java.beans.BeanInfo;
        import java.beans.Introspector;
        import java.beans.PropertyDescriptor;
        import java.lang.reflect.Method;
        import java.text.DateFormat;
        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Date;

        import com.reflect.entity.Student;
        import org.apache.commons.beanutils.BeanUtils;
        import org.apache.commons.beanutils.ConvertUtils;
        import org.apache.commons.beanutils.Converter;
        import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class Demo {
    public static void main(String[] args) throws Exception {
        test1();
    }
//    @Test
    public static void test1() throws Exception{
        //获得指定的beanInfo对象
        BeanInfo beanInfo = Introspector.getBeanInfo(Student.class);
        //获得属性描述数组
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        //遍历：因为类继承Object类，Object类中有一个getClass()方法，所以个数会比你写的多一个
        System.out.println(pds.length);
        for(PropertyDescriptor pd:pds){
            System.out.print(pd.getName()+"  ");
        }
        System.out.println();
        //获得指定的PropertyDescriptor
        PropertyDescriptor pd=new PropertyDescriptor("name", Student.class);
        //获得get方法
        Method m=pd.getReadMethod();
        Student s=new Student();
        String str=(String)m.invoke(s, null);
        System.out.println(str);
        //获得set方法
        Method m1=pd.getWriteMethod();
        m1.invoke(s, "aaa");
        System.out.println(s.getName());
    }

    //@Test
    public void test2() throws Exception{
        Student s=new Student();


        //调用get方法:getProperty返回值是String，因为一切数据都是以String来显示的
        String age= BeanUtils.getProperty(s, "age");
        System.out.println(age);

        //调用set方法：
        //BeanUtils可以进行类型的自动转换，但仅限基本类型：本来需要int型，给个字符串，ok
        BeanUtils.setProperty(s, "name", "aaa");
        BeanUtils.setProperty(s, "age", "123");
        System.out.println("name:"+s.getName());
        System.out.println("age:"+s.getAge());
    }
    //非基本类型的属性设置
    //用户的输入都是String
    //String <----->其他类型间的互相转换
    //用户看到的结果都是String
//    @Test
    public void test3() throws Exception{
        Student s=new Student();
        //为BeanUtils注册类型转换器：自定义转换器

        ConvertUtils.register(new Converter() {
            DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            //type:目标类型
            //value:当前传入的值
            public Object convert(Class type, Object value) {
                if(value instanceof String){//字符串转Date
                    String d=(String) value;
                    java.util.Date date=null;
                    try {
                        date=df.parse(d);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return date;
                }else{//Date转换为字符串
                    String date=df.format(value);
                    return date;
                }
//              if(type.equals(Date.class)){
//                  //字符串转换为Date
//              }else{
//                  //Date转换为字符串
//              }
            }
        }, Date.class);
        BeanUtils.setProperty(s, "birthday", "2013-5-12");
        System.out.println(s.getBirthday());
    }
    //利用BeanUtils中写好的Date转换器
//    @Test
    public void test4() throws Exception{
        Student s=new Student();
        ConvertUtils.register(new DateLocaleConverter(), Date.class);
        BeanUtils.setProperty(s, "birthday", "2014-10-3");
        System.out.println(s.getBirthday());
    }
}