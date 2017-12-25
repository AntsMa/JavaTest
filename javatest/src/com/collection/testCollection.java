package com.collection;

import com.reflect.entity.Person;

import java.util.*;

/**
 * ${DESCRIPTION}
 *
 * @author masc
 * @create 2017.03.22 17:09
 */
public class testCollection {
    public static void main(String[] args) {
       ///11111
        List list = new ArrayList();
        list.add(null);
        list.add(null);
        System.out.println(list.get(0)+"__"+list.get(1));

        List list1 = new LinkedList();
        list1.add(null);
        list1.add(null);
        System.out.println(list1.get(0)+"__"+list1.get(1));
///2222
        Set set = new HashSet();
        set.add("111");
        set.add("222");
        set.add("333");
        set.add("333");
        set.add("44");

        List list3 = new ArrayList();
        list3.add("list111");
        list3.add("list333");
        set.add(list3);
        System.out.println(set.size());
        for (Iterator it = set.iterator();it.hasNext();){
            System.out.println(it.next().toString());
        }

////333
        Set treeSet = new TreeSet();
        treeSet.add("111");
        treeSet.add("222");
        treeSet.add("333");
        treeSet.add("333");
        treeSet.add("44");
        treeSet.add("b4");
        treeSet.add("a4");
        treeSet.add("A4");
        List list4 = new LinkedList();
        list4.add("list4_111");
        list4.add("list4_333");
//        treeSet.add(list4);
        System.out.println("size_"+treeSet.size());
        for (Iterator it = treeSet.iterator();it.hasNext();){
            System.out.println(it.next().toString());
        }

 //   4444
        Set<Person> personSet = new HashSet<Person>();
        Person person = new Person();
        person.setAge("1");
        person.setSex("2");
        personSet.add(person);
        Person person2 = new Person();
        person2.setAge("2");
        person2.setSex("3");
        personSet.add(person);
        for (Iterator<Person> it = personSet.iterator();it.hasNext();){
            Person person1 =  it.next();
            System.out.println(person1.getAge()+"__"+person1.getSex());
        }

//555
        System.out.println("------------MyComparator----------");
        Set<String> setCom = new TreeSet<String>(new MyComparator());

        setCom.add("a");
        setCom.add("b");
        setCom.add("c");
        setCom.add("d");
        setCom.add("e");
        setCom.add("A");

        for(Iterator<String> iterator = setCom.iterator();iterator.hasNext();){
            System.out.print(iterator.next()+" ");
        }

//666666666666
        System.out.println("\r\n"+"-----------StudentComparator----------");
        Set<Student> setSt = new TreeSet<Student>(new StudentComparator());

        Student p1 =  new Student(10);
        Student p2 =  new Student(20);
        Student p3 =  new Student(30);
        Student p4 =  new Student(40);

        setSt.add(p1);
        setSt.add(p2);
        setSt.add(p3);
        setSt.add(p4);

        for(Iterator<Student> iterator = setSt.iterator();iterator.hasNext();){
            System.out.print(iterator.next().score+" ");
        }

    }
}
