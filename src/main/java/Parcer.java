import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parcer {
    String filePath = "airports.csv";
    String separator =",";


    public Parcer( String filePath) {
        this.filePath = filePath;
    }

    public void getKeysValues(int column_number) throws IOException {
        List<String> records = Files.readAllLines(Paths.get("airports.csv"));
        String separator = ",";
        HashMap<String, String> map = new HashMap<>();
        int countRecord =0;
        for (String record : records) { // line - запись
            String[] string = record.split(separator); // string - массив с ячейками из таблицы csv
            System.out.println("key: " + string[1] + "value: " + string[0]);
            countRecord++;
        }
        System.out.println("countRecord = " + countRecord);

    }
}
