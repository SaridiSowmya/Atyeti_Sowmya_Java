package main.java;

public class SameVariableNaming {

    public void method1()
    {
        int i=10;
        System.out.println("value is "+i);
    }

    public void method2()
    {
        int i =20;
        System.out.println("value is "+i);

    }

    public static void main(String[] args) {
        SameVariableNaming sv =new SameVariableNaming();
        sv.method1();
        sv.method2();
    }

}
