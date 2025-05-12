package main.java;

public class PrimitiveTypes {
    public static void main(String[] args) {

        byte b=5;
        System.out.println("the value of byte is:"+Integer.toBinaryString(b));

        short s=32767;
        System.out.println("the value of short is:"+Integer.toBinaryString(s));


        int i=25;
        System.out.println("the value of int is:" +Integer.toBinaryString(i));


        long l=98345678912L;
        System.out.println("the value long is:" +Long.toBinaryString(l));


        float f=4.25f;
        System.out.println("the value of float is:" +Integer.toBinaryString((int) f));


        double d=19.99;
        System.out.println("the value of double is:"+ d +Long.toBinaryString((long) d));


        char c='A';
        System.out.println("the value char s:" +Integer.toBinaryString(c));

        boolean bool=true;
        System.out.println("the value of bool is:" +(bool ? "1":"0"));

    }
}

