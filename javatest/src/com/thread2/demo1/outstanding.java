package com.thread2.demo1;

/**
 * ${DESCRIPTION}
 *
 * @author masc
 * @create 2017.06.12 15:26
 */
public class outstanding {



    public static void main(String[] args) {
        Internal internal = new Internal();
        barred barred = new barred(internal);
        Thread revised = new Thread(barred);
        revised.setName("revised");
        revised.start();
        Thread  proposed = new Thread(barred);
        proposed.setName("propsed");
        proposed.start();
        Thread  illustrate = new Thread(barred);
        illustrate.setName("illustrate");
        illustrate.start();
    }
}

class barred implements Runnable{
    private Internal internal;
    public  barred(Internal internal){
        this.internal = internal;
    }

    @Override
    public void run() {
        internal.correspondent();
        Internal.appendix();
    }
}


class Internal {
    public synchronized void correspondent(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"。。。。correspondent。。。。。"+i);
        }
    }

    public  synchronized  static  void appendix(){
        for (int i = 11; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+".....appendix....."+i);
        }
    }
}
