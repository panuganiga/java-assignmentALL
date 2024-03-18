import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductDatabase database = new ProductDatabase();

        Product product1 = new Product("Laptop", "Electronics", "Brand-X laptop", 1500, "BrandX");
        Product product2 = new Product("Smartphone", "Electronics", "Brand-Y smartphone model", 800, "BrandY");
        Product product3 = new Product("Book", "Books", "Bestselling novel", 20, "PublisherA");
        Product product4 = new Product("Pen", "Stationery", "Ballpoint pen", 5, "BrandZ");
        Product product5 = new Product("Pencil", "Stationery", "HB pencil", 2, "BrandZ");
        Product product6 = new Product("Soap", "Toiletries", "Fragrant soap", 3, "BrandA");
        Product product7 = new Product("Bucket", "Household", "Large plastic bucket", 10, "BrandB");
        Product product8 = new Product("Smartwatch", "Wearable", "Fitness smartwatch", 100, "BrandC");

        database.addProduct(product1);
        database.addProduct(product2);
        database.addProduct(product3);
        database.addProduct(product4);
        database.addProduct(product5);
        database.addProduct(product6);
        database.addProduct(product7);
        database.addProduct(product8);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Product Name: ");
        String keyword = scanner.nextLine();
        scanner.close();

        List<Product> searchResults = database.searchProducts(keyword);

        System.out.println("Product Detail:");
        if (searchResults.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Product product : searchResults) {
                System.out.println(product.getName() + " - " + product.getDescription() + " - Price: $" + product.getPrice() + " - Brand: " + product.getBrand());
            }
        }
    }
}
