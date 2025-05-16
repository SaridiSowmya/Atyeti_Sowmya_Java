package classesandobjects;

import java.util.Scanner;

public class Product {
        int productId;
        String productName;

        public void setProductData()
        {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Product Id :");
            productId = sc.nextInt();

            System.out.print("Enter Product Name :");
            productName = sc.nextLine();
            productName = sc.nextLine();
            sc.close();
        }

        public void getProductData()
        {
            System.out.println("Product is :"+productId);
            System.out.println("Product Name is :"+productName);
        }


        public static void main(String[] args)
        {
            Product laptop = new Product();
            //laptop.getProductData();

            laptop.setProductData();
            laptop.getProductData();

        }

    }

