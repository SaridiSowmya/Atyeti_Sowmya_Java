package zoomanagementsystem;

public class ZooManagement {

    public static void main(String[] args) {
        Animal lion = new Lion("Leo");
        Animal elephant = new Elephant("Ella");

        Animal[] animals = {lion, elephant};

        for (Animal a : animals) {
            a.eat();
            if (a instanceof Soundable) {
                ((Soundable) a).makeSound();
            }
        }
    }
}

