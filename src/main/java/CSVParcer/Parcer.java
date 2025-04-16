package CSVParcer;

import PrefixTreeAlgoritm.PrefixTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Parcer {
    String filePath = "airports.csv";
    String separator = ",";


    public Parcer(String filePath) {
        this.filePath = filePath;
    }

    public static PrefixTree getKeysValues(int column_number) throws IOException {
        PrefixTree tree = new PrefixTree();
        //Todo init block исправленный под 1 задачу

        // Парсинг из CSV-файла
        List<String> records = Files.readAllLines(Paths.get("airports.csv"));
        String separator = ",";
        char kavichka = '\"';
        for (String record : records) {// line - запись
            String normal_record = record.replace("\"", "");
            String[] string = normal_record.split(separator); // string - массив с ячейками из таблицы csv
            tree.insert(string[column_number], string[0]);
        }
        return tree;
    }

    public static void main(String[] args) throws IOException {
        Parcer.getKeysValues(4);

    }
}
