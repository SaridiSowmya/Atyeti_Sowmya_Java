package switchproblems;

import java.util.Scanner;

public class SwitchDemo1 {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter your choice :");

        String year = sc.nextLine();

        switch(year)
        {
            case "january" :
                System.out.println("jan month") ;
                break;
            case "february" :
                System.out.println("feb month");
                break;
            case "april" :
                System.out.println("april month");
                break;
            case "may" :
                System.out.println("may month");
                break;
            case "june" :
                System.out.println("june month") ;
                break;
            case "july" :
                System.out.println("july month");
                break;
            case "august" :
                System.out.println("august month");
                break;
            case "september" :
                System.out.println("sep month");
                break;
            case "october" :
                System.out.println("oct month");
                break;
            case "november" :
                System.out.println("november month");
                break;
            case "december" :
                System.out.println("decem month");
                break;

                default : System.out.println("No colour");
        }
        System.out.println("Completed") ;
    }
}


