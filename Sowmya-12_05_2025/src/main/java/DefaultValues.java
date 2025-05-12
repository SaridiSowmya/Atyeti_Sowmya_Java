package main.java;

public class DefaultValues {

    int i;
    int j;

    public void printdefaultvalues()
    {
        System.out.println("value of i:"+i);
        System.out.println("value of j:"+j);


    }

    public void localvalues(){
        int a;
        int b;

        //shows error because not initialized the local variables

      // System.out.println("the value of a is:"+a);
       // System.out.println("the value of b is:"+b);

    }

    public static void main(String[] args) {
        DefaultValues d = new DefaultValues();
       d.printdefaultvalues();
       d. localvalues(); // not print anything until you initialize the localvariables


    }



}
