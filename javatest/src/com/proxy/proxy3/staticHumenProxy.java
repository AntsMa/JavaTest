package com.proxy.proxy3;

/**
 * Created by shichen.ma on 2017/7/27.
 */
public class staticHumenProxy implements Humen {

    private Humen humen;

    public staticHumenProxy(){
        humen = new HumenImpl();
    }

    @Override
    public void eat(String food) {
        before();
        humen.eat(food);
        after();
    }

    private void before(){
        System.out.println("cook");
    }

    private void after(){
        System.out.println("swap");
    }
}
