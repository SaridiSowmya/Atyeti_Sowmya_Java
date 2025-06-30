package zoomanagementsystem;

import static java.lang.Character.getName;
class Lion extends Animal implements Soundable {
    public Lion(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " the lion eats meat.");
    }


    @Override
    public void makeSound() {
        System.out.println(getName() + " roars!");
    }
}
