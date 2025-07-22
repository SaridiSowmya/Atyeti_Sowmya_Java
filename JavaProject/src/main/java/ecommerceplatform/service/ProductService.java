package ecommerceplatform.service;
import ecommerceplatform.model.Product;
import ecommerceplatform.util.CSVUtil;

import java.io.*;
import java.util.*;

public class ProductService {
    private static final String PRODUCT_FILE = "C:\\Users\\SowmyaSaridi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sowmya_Java\\JavaProject\\src\\main\\java\\ecommerceplatform\\data\\products.csv";
    private static List<Product> productList = new ArrayList<>();

    static {
        loadProducts();
    }

    private static void loadProducts() {
        productList.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(PRODUCT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                int quantity = Integer.parseInt(parts[3]);
                productList.add(new Product(id, name, price, quantity));
            }
        } catch (IOException e) {
            System.out.println("Failed to load products: " + e.getMessage());
        }
    }

    public static void addProduct(String name, double price, int quantity) {
        int id = productList.size() + 1;
        Product p = new Product(id, name, price, quantity);
        productList.add(p);
        saveProductToFile(p);
    }

    public static List<Product> getAllProducts() {
        return productList;
    }

    public static Product findById(int id) {
        return productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

    }

    public static void updateProductQuantity(int productId, int quantityPurchased) {
        List<String[]> rows = CSVUtil.read(PRODUCT_FILE);

        for (String[] row : rows) {
            if (Integer.parseInt(row[0]) == productId) {
                int oldQty = Integer.parseInt(row[3]);
                row[3] = String.valueOf(oldQty - quantityPurchased);
                break;
            }
        }

        CSVUtil.overwrite(PRODUCT_FILE, rows);
    }

    public static void updateStockQuantity(int productId, int newQuantity) {
        List<String[]> rows = CSVUtil.read(PRODUCT_FILE);

        for (String[] row : rows) {
            if (Integer.parseInt(row[0]) == productId) {
                row[3] = String.valueOf(newQuantity);
                break;
            }
        }

        CSVUtil.overwrite(PRODUCT_FILE, rows);
        loadProducts();
    }


    private static void saveProductToFile(Product product) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PRODUCT_FILE, true))) {
            bw.write(product.getId() + "," + product.getName() + "," + product.getPrice() + "," + product.getQuantity());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing product: " + e.getMessage());
        }
    }
}




