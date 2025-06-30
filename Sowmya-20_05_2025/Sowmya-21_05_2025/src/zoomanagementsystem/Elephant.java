package zoomanagementsystem;

class Elephant extends Animal implements Soundable {
    public Elephant(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " the elephant eats plants.");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " trumpets!");
    }
}