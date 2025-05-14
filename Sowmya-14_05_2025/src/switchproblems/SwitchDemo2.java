package switchproblems;

import java.util.Scanner;

public class SwitchDemo2 {
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the name of the season :");
            String season = sc.next().toLowerCase();

            switch(season)
            {
                case "summer" :
                    System.out.println("It is summer Season!!");
                    break;

                case "rainy" :
                    System.out.println("It is Rainy Season!!");
                    break;

                case "winter" :
                    System.out.println("It is winter Season!!");
                    break;

                case "spring" :
                    System.out.println("It is spring Season!!");
                    break;

                default:
                    System.out.println("no such of season avaialable");
            }
        }
    }



