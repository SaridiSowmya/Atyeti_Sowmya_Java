package main.java;

public class VariableShadowing {
        int num = 10; //instance variable

        public void showNumber() {
            int num = 20; //local variable
            System.out.println("Local variable: " + num);
            System.out.println("Instance variable: " + this.num);
        }

        public static void main(String[] args) {
            VariableShadowing v = new VariableShadowing();
            v.showNumber();
        }
    }

