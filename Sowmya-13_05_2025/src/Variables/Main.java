package Variables;

class A {
        static int value = 100; // static variable
    }
    // Class with an instance variable (same name)
    class B {
        int value = 200; // instance variable
    }

    public class Main {
        public static void main(String[] args) {
            // Access static variable using class name
            System.out.println("ClassA static value: " + A.value);

            // Create an object of ClassB
            B objB = new B();

            // Access instance variable using object reference
            System.out.println("ClassB instance value: " + objB.value);
        }
    }
