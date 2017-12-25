package com.thread.demo2;

/**
* Java线程：并发协作-生产者消费者模型
*
* @author leizhimin 2009-11-4 14:54:36
*/
public class Test {
        public static void main(String[] args) {


                start();

                
                
        }


        public synchronized static void  start(){
                Godown godown = new Godown(30);
                Consumer c1 = new Consumer("c1",50, godown);
                Consumer c2 = new Consumer("c2",20, godown);
                Consumer c3 = new Consumer("c3",30, godown);
                Producer p1 = new Producer("p1",10, godown);
                Producer p2 = new Producer("p2",10, godown);
                Producer p3 = new Producer("p3",10, godown);
                Producer p4 = new Producer("p4",10, godown);
                Producer p5 = new Producer("p5",10, godown);
                Producer p6 = new Producer("p6",10, godown);
                Producer p7 = new Producer("p7",80, godown);
                c1.start();
                c2.start();
                c3.start();
                p1.start();
                p2.start();
                p3.start();
                p4.start();
                p5.start();
                p6.start();
                p7.start();
        }
        
        /*
3368214---c1----consume:curnum:30__neednum:50
3567720---c2----已经消费了20个产品，现仓储量为10
3639621---c1----consume:curnum:10__neednum:50
3694930---c3----consume:curnum:10__neednum:30
3770387---p1----已经生产了10个产品，现仓储量为20
3829646---p2----已经生产了10个产品，现仓储量为30
3896016---p3----已经生产了10个产品，现仓储量为40
3978189---c3----已经消费了30个产品，现仓储量为10
4033893---c1----consume:curnum:10__neednum:50
4097498---p7----已经生产了80个产品，现仓储量为90
4166238---p6----已经生产了10个产品，现仓储量为100
4322287---p5----要生产的产品数量10超过剩余库存量0，暂时不能执行生产任务!
4441201---p5---produce:curnum:100__neednum:10
4491374---p4----要生产的产品数量10超过剩余库存量0，暂时不能执行生产任务!
4569991---p4---produce:curnum:100__neednum:10
4603966---c1----已经消费了50个产品，现仓储量为50
4718534---p4----已经生产了10个产品，现仓储量为60
4827966---p5----已经生产了10个产品，现仓储量为70

151931703812579---c1----consume:curnum:30__neednum:50
151931704115196---c3----已经消费了30个产品，现仓储量为0
151931704256233---p4----已经生产了10个产品，现仓储量为10
151931704321418---p3----已经生产了10个产品，现仓储量为20
151931704384628---p1----已经生产了10个产品，现仓储量为30
151931704457319---p2----已经生产了10个产品，现仓储量为40
151931704519739---c2----已经消费了20个产品，现仓储量为20
151931704573468---c1----consume:curnum:20__neednum:50
151931704661171---p6----已经生产了10个产品，现仓储量为30
151931704714109---p5----已经生产了10个产品，现仓储量为40
151931704813665---p7----要生产的产品数量80超过剩余库存量60，暂时不能执行生产任务!
151931704878455---p7---produce:curnum:40__neednum:80
151931704915591---c1----consume:curnum:40__neednum:50
*/
} 





