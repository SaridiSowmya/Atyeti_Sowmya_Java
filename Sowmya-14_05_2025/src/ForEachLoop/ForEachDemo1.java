package ForEachLoop;

//working of for each

public class ForEachDemo1 {
    public static void main(String[] args) {


        int []x ={56,34,35,36,7,13,25,87,67};
        java.util.Arrays.sort(x);
        for(int y : x)
        {
            System.out.println(y);
        }
    }
}
