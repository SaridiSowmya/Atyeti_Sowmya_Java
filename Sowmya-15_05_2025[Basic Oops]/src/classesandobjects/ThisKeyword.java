package classesandobjects;

public class ThisKeyword {
        int productId;
        String productName;

        public void setProductData(int productId, String productName)
        {
            this.productId = productId;
            this.productName = productName;

        }

        public void getProductData()
        {
            System.out.println("Product Id is :"+this.productId);
            System.out.println("Product Name is :"+this.productName);
        }
    }



