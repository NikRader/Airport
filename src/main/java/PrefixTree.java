import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrefixTree {
    private static class Node {
        Map<Character, Node> children = new HashMap<>();
        List<String> values = new ArrayList<>();
    }

    private final Node root = new Node();

    // Вставка key -> value
    public void insert(String key, String value) {
        Node node = root;
        for (char ch : key.toCharArray()) {
            node = node.children.computeIfAbsent(ch, c -> new Node());
        }
        node.values.add(value);
    }

    public List<String> searchAllByPrefix(String prefix) {
        List<String> result = new ArrayList<>();

        Node node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) {
                return result; // Нет такого префикса
            }
        }

        // Собираем все value начиная с найденного узла
        collectAllValues(node, result);
        return result;
    }

    private void collectAllValues(Node node, List<String> result) {
        result.addAll(node.values);
        for (Node child : node.children.values()) {
            collectAllValues(child, result);
        }
    }

}