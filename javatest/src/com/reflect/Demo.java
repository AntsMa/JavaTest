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
        //���ָ����beanInfo����
        BeanInfo beanInfo = Introspector.getBeanInfo(Student.class);
        //���������������
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        //��������Ϊ��̳�Object�࣬Object������һ��getClass()���������Ը��������д�Ķ�һ��
        System.out.println(pds.length);
        for(PropertyDescriptor pd:pds){
            System.out.print(pd.getName()+"  ");
        }
        System.out.println();
        //���ָ����PropertyDescriptor
        PropertyDescriptor pd=new PropertyDescriptor("name", Student.class);
        //���get����
        Method m=pd.getReadMethod();
        Student s=new Student();
        String str=(String)m.invoke(s, null);
        System.out.println(str);
        //���set����
        Method m1=pd.getWriteMethod();
        m1.invoke(s, "aaa");
        System.out.println(s.getName());
    }

    //@Test
    public void test2() throws Exception{
        Student s=new Student();


        //����get����:getProperty����ֵ��String����Ϊһ�����ݶ�����String����ʾ��
        String age= BeanUtils.getProperty(s, "age");
        System.out.println(age);

        //����set������
        //BeanUtils���Խ������͵��Զ�ת���������޻������ͣ�������Ҫint�ͣ������ַ�����ok
        BeanUtils.setProperty(s, "name", "aaa");
        BeanUtils.setProperty(s, "age", "123");
        System.out.println("name:"+s.getName());
        System.out.println("age:"+s.getAge());
    }
    //�ǻ������͵���������
    //�û������붼��String
    //String <----->�������ͼ�Ļ���ת��
    //�û������Ľ������String
//    @Test
    public void test3() throws Exception{
        Student s=new Student();
        //ΪBeanUtilsע������ת�������Զ���ת����

        ConvertUtils.register(new Converter() {
            DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            //type:Ŀ������
            //value:��ǰ�����ֵ
            public Object convert(Class type, Object value) {
                if(value instanceof String){//�ַ���תDate
                    String d=(String) value;
                    java.util.Date date=null;
                    try {
                        date=df.parse(d);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return date;
                }else{//Dateת��Ϊ�ַ���
                    String date=df.format(value);
                    return date;
                }
//              if(type.equals(Date.class)){
//                  //�ַ���ת��ΪDate
//              }else{
//                  //Dateת��Ϊ�ַ���
//              }
            }
        }, Date.class);
        BeanUtils.setProperty(s, "birthday", "2013-5-12");
        System.out.println(s.getBirthday());
    }
    //����BeanUtils��д�õ�Dateת����
//    @Test
    public void test4() throws Exception{
        Student s=new Student();
        ConvertUtils.register(new DateLocaleConverter(), Date.class);
        BeanUtils.setProperty(s, "birthday", "2014-10-3");
        System.out.println(s.getBirthday());
    }
}