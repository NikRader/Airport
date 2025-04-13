import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        PrefixTree tree = new PrefixTree();
        String prefix = "ai";
        List<String> records = Files.readAllLines(Paths.get("airports.csv"));
        String separator = ",";
        char kavichka = '\"';

        int countRecord = 0;
        int countAddInTree = 0;
        for (String record : records) {// line - запись
            String normal_record = record.replace("\"", "");
            String[] string = normal_record.split(separator); // string - массив с ячейками из таблицы csv
            System.out.println("key: " + string[12] + " value: " + string[0]);
            tree.insert(string[12], string[0]);

            countAddInTree++;
            countRecord++;
        }
        List<String> list = tree.searchAllByPrefix(prefix);

        System.out.println("Список Номеров записей по Префиксу " + prefix + ": " + list);
        System.out.println("Размер списка с подходящими номерами= " + list.size());
        System.out.println("countRecord = " + countRecord);
        System.out.println("countAddInTree = " + countAddInTree);

    }
}
