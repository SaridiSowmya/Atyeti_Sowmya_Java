package Variables;

public class FinalVariable {

    public void finalVar()
    {
        final int fin =10;
        System.out.println("the value of my final variable :" + fin);
    }

    // cause compile time error you cant reasiign the final variable once its initialized
    // fin=20;



    public static void main(String[] args) {

        FinalVariable fv=new FinalVariable();
        fv.finalVar();



    }
}