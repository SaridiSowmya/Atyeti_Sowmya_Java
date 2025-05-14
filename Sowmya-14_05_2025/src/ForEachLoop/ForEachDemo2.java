package ForEachLoop;

public class ForEachDemo2 {
    public static void main(String[] args) {

        String []names ={"john","cris","david","martin"};
       // java.util.Arrays.sort(names);
        for(String nameList : names)
        {
            System.out.println(nameList);
        }
    }
}





