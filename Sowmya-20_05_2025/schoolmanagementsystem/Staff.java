package schoolmanagementsystem;

public class Staff extends Person{

    private String jobRole;


    public Staff(String name, String address, String JobRole) {
        super(name, address);
        this.jobRole=jobRole;

    }

    public void updateRecord(String jobRole) {
        this.jobRole = jobRole;
    }

    @Override
    public String toString() {
        return super.toString() + "\nJob Role: " + jobRole;
    }
}
