package PrefixTreeAlgoritm;

import createJSON.PackResponse;

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

    // Поиск по префиксу с возвратом PackResponse
    public PackResponse searchByPrefix(String prefix) {
        long startTime = System.nanoTime();  // Засекаем время в наносекундах
        List<String> result = new ArrayList<>();

        Node node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) {
                long endTime = System.nanoTime();
                int timeMicros = (int)((endTime - startTime) / 1000); // Переводим в микросекунды
                return new PackResponse(prefix, result, timeMicros);
            }
        }

        // Собираем все value начиная с найденного узла
        collectAllValues(node, result);

        long endTime = System.nanoTime();
        int timeMicros = (int)((endTime - startTime) / 1000); // Переводим в микросекунды

        return new PackResponse(prefix, result, timeMicros);
    }

    private void collectAllValues(Node node, List<String> result) {
        result.addAll(node.values);
        for (Node child : node.children.values()) {
            collectAllValues(child, result);
        }
    }
}