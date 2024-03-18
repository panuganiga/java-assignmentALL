import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchIndex {
    private Map<String, List<String>> index;

    public SearchIndex() {
        this.index = new HashMap<>();
    }

    public void index(String word) {
        String key = word.toLowerCase();
        index.putIfAbsent(key, new ArrayList<>());
        index.get(key).add(word);
    }

    public List<String> search(String keyword) {
        return index.getOrDefault(keyword.toLowerCase(), new ArrayList<>());
    }
}
