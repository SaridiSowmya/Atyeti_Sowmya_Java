package classesandobjects;

public class ThisKeyword {

        int productId;
        String productName;

        public void setProductData(int productId, String productName) {
            this.productId = productId;
            this.productName = productName;

        }

        public void getProductData() {
            System.out.println("Product Id is :" + this.productId);
            System.out.println("Product Name is :" + this.productName);
        }

    }
public class ProductDemo
{
    public static void main(String[] args)
    {
        Product camera = new Product();
        camera.setProductData(111, "Nikon");
        camera.getProductData();
    }

}


