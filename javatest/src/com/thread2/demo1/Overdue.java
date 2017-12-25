package com.thread2.demo1;


/**
 * @author Jack Zhang
 * @version vb1.0
 * @Email virgoboy2004@163.com
 * @Date 2012-5-20
 */
public class Overdue
{
    public final static Byte[] locks = new Byte[0];

    public static void staticX() throws InterruptedException
    {
        synchronized (locks)
        {
            for (int i = 0; i < 10; i++)
            {
                Thread.sleep(1000);
                System.out.println("staticX.......................");
            }
        }
    }

    public void x() throws InterruptedException
    {
        synchronized (locks)
        {
            for (int i = 0; i < 10; i++)
            {
                Thread.sleep(1000);
                System.out.println("x.......................");
            }
        }
    }

    public static void main(String[] args)
    {
        final Overdue test1 = new Overdue();
        final Overdue test2 = new Overdue();
        Thread thread = new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    test1.x();
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, "a");

        Thread thread1 = new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    Overdue.staticX();
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, "b");

        thread1.start();
        thread.start();
    }
}