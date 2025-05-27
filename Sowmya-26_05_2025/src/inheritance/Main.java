package inheritance;

public class Main {

    public static void main(String[] args) {

        Manager m1 = new Manager("sowmya", 1001, 90000, "Human Resources");
        Developer d1 = new Developer("someswari", 1002, 85000, "Java");

        System.out.println("Manager Info:");
        m1.displayInfo();

        System.out.println("\nDeveloper Info:");
        d1.displayInfo();


    }
}
