package QueryHandler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TextFile {
    public static void create(List<String> goodSearches) {
        // Проверяем, что список не null и содержит непустые строки
        if (goodSearches == null || goodSearches.isEmpty() ||
                goodSearches.stream().allMatch(String::isBlank)) {
            System.out.println("Файл не создан: список запросов пуст или содержит только пустые строки");
            return;
        }

        try (FileWriter writer = new FileWriter("UserSearches.txt")) {
            for (String str : goodSearches) {
                if (str != null && !str.isBlank()) {
                    writer.write(str + '\n');
                }
            }
            System.out.println("Файл UserSearches.txt успешно создан!");
        } catch (IOException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}