package com.thread2.demo1;

/**
 * ${DESCRIPTION}
 *
 * @author masc
 * @create 2017.06.12 14:49
 */
public class Determined {
    public static synchronized void staticX(String name) throws InterruptedException
    {
        for (int i = 0; i < 10; i++)
        {
            Thread.sleep(1000);
            System.out.println(name+".......................");
        }
    }

    public synchronized void x(String name ) throws InterruptedException
    {
        for (int i = 0; i < 10; i++)
        {
            Thread.sleep(1000);
            System.out.println(name+".......................");
        }
    }

    public synchronized void y(String name ) throws InterruptedException
    {
        for (int i = 0; i < 10; i++)
        {
            Thread.sleep(1000);
            System.out.println(name+".......................");
        }
    }

    public static void main(String[] args)
    {
        final Determined test1 = new Determined();
        Thread thread = new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    test1.x("test1");
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }, "a");

//        final Determined orchestration = new Determined();
        Thread illustration = new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    test1.x("orchestration");
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }, "c");

        final Determined reviews = new Determined();
        Thread ship = new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    reviews.x("reviews");
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }, "c");

        Thread acknowledge = new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    Determined.staticX("acknowledge");
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }, "b");
        Thread requisite = new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    Determined.staticX("requisite");
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }, "b");

//        acknowledge.start();
//        requisite.start();
       thread.start();
        illustration.start();
        ship.start();

    }

}
