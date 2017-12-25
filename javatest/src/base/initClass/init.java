package base.initClass;


class Base {
    int a;
    static int b;
    static int c = 1;

    static {
        b=2;
        c = 3;
        System.out.println("Base:static init block invoked..");
    }

    void display() {
        System.out.println("Base:a=" + a + ",b=" + b + ",c=" + c);
    }

}

class Derived extends Base {
    int d;
    static int e = 4;

    static {
        e= 5;
        System.out.println("Derived:static init block invoked...");
    }

    void display() {
        super.display();
        System.out.println("Derived:d=" + d + ",e=" + e);
    }
}

 class Demo {
    static int f;
    static{
        f=100;
        System.out.println("Demo:static init block invoked..and f="+f);
    }

    public static void main(String[] args) {
        //-------
        //----------
        System.out.println("maininvoked..");

        //-------------------
        System.out.println(Derived.e);
        new Derived().display();
    }}