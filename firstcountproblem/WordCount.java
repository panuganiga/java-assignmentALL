import java.io.*;
import java.util.*;

// Trie node class
class TrieNode {
    Map<Character, TrieNode> children;
    int count;

    public TrieNode() {
        this.children = new HashMap<>();
        this.count = 0;
    }
}

// Trie data structure for word storage
class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.count++;
    }

    // Search for a word in the trie
    public int search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return 0;
            }
            current = current.children.get(ch);
        }
        return current.count;
    }
}

public class WordCount {
    // Read the large text file and process it
    public static void processFile(String filename, Trie trie) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    // Remove non-alphabetic characters and convert to lowercase
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (!word.isEmpty()) {
                        trie.insert(word);
                    }
                }
            }
        }
    }

    // Emit sorted words along with their counts
    public static void emitWordCounts(Trie trie) {
        emitWordCountsHelper("", trie.root);
    }

    private static void emitWordCountsHelper(String prefix, TrieNode node) {
        if (node.count > 0) {
            System.out.println(prefix + ": " + node.count);
        }
        for (char ch : node.children.keySet()) {
            emitWordCountsHelper(prefix + ch, node.children.get(ch));
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filename = scanner.nextLine();
        scanner.close();
        try {
            processFile(filename, trie);
            emitWordCounts(trie);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}