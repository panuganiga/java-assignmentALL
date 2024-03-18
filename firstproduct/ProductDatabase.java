import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductDatabase {
    private List<Product> products;
    private SearchIndex searchIndex;

    public ProductDatabase() {
        this.products = new ArrayList<>();
        this.searchIndex = new SearchIndex();
    }

    public void addProduct(Product product) {
        products.add(product);
        indexProduct(product);
    }

    public List<Product> searchProducts(String keyword) {
        List<String> matchingWords = searchIndex.search(keyword);
        Set<Product> resultSet = new HashSet<>();

        for (String word : matchingWords) {
            for (Product product : products) {
                if (product.getName().toLowerCase().contains(word.toLowerCase()) ||
                    product.getCategory().toLowerCase().contains(word.toLowerCase()) ||
                    product.getDescription().toLowerCase().contains(word.toLowerCase()) ||
                    product.getBrand().toLowerCase().contains(word.toLowerCase())) {
                    resultSet.add(product);
                }
            }
        }

        return new ArrayList<>(resultSet);
    }

    private void indexProduct(Product product) {
        searchIndex.index(product.getName());
        searchIndex.index(product.getCategory());
        searchIndex.index(product.getDescription());
        searchIndex.index(product.getBrand());
    }
}
