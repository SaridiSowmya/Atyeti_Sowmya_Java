package studentrecordmanagementsystem;

public class Student {

    private String rollNo;
    private String name;
    private int[] marks;

    public Student(String rollNo, String name, int[] marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    public int getTotal() {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum;
    }

    public double getAverage() {
        return getTotal() / (double) marks.length;
    }

    public String getRollNo() {
        return rollNo;
    }
    public String getName() {
        return name;
    }
    public int[] getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public String toCSV() {
        return rollNo + "," + name + "," + marks[0] + "," + marks[1] + "," + marks[2];
    }

    public String toString() {
        return "Roll: " + rollNo + " | Name: " + name +
                " | Marks: [" + marks[0] + ", " + marks[1] + ", " + marks[2] + "]" +
                " | Total: " + getTotal() + " | Avg: " + String.format("%.2f", getAverage());
    }
}
