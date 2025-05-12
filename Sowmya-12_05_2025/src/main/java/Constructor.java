package main.java;

public class Constructor {

    int id;
    String name;

    public Constructor()
    {

    }

    public Constructor(int id,String name)
    {
        this.id =id;
        this.name= name;
    }

    public void printInfo() {
        System.out.println("id: " + id);

        System.out.println("Name: " + name);

        System.out.println("-------------------");
    }

    public static void main(String[] args) {

        Constructor c1=new Constructor();
        System.out.println("using default constructor ");
        c1.printInfo();


        Constructor c2= new Constructor(1,"sowmya");

        System.out.println("using parametarized constructor");

        c2.printInfo();


    }
}
