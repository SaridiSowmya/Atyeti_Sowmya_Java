package main.java;

public class InstanceInitializers {

    int id;
    String name;

    {
        id=1;
        name="sowmya";
    }

    {
        id=2;
        name="somi";
    }

    InstanceInitializers()
    {
        System.out.println("id id:"+id);
        System.out.println("name is:"+name);
    }

    public static void main(String[] args) {
        InstanceInitializers ii = new InstanceInitializers();
        InstanceInitializers ii1 = new InstanceInitializers();

    }


}
