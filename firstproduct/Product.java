public class Product {
    private String name;
    private String category;
    private String description;
    private int price;
    private String brand;

    public Product(String name, String category, String description, int price, String brand) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }
}
