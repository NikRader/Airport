import CSVParcer.Parcer;
import PrefixTreeAlgoritm.PrefixTree;
import QueryHandler.QueryHandler;
import QueryHandler.TextFile;
import QueryHandler.SearchesScanner;
import createJSON.CreateJsonWithGson;
import createJSON.PackJson;
import createJSON.PackResponse;
import СommandLineOptions.OptionsCLI;

import java.io.IOException;
import java.util.*;

public class Main {
    private static long programStartTime;
    private static int initTime;

    public static void main(String[] args) throws IOException {
        programStartTime = System.currentTimeMillis();
        //Todo init block исправленный под 1 задачу
        OptionsCLI.showOptions(args);
        //пользовательский ввод
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер столбца для поиска, начиная с 1:");

        int columnId = sc.nextInt();
        PrefixTree tree = Parcer.getKeysValues(columnId-1);

        List<String> searches = SearchesScanner.SearchesScanner();
        initTime = (int) (System.currentTimeMillis() - programStartTime);
        //обработка пользовательского ввода
        List<String> goodSearches = QueryHandler.checkQuery(searches);
        //создание файла txt
        TextFile.create(goodSearches);
        //
        List<PackResponse> packResponseList = new ArrayList<>();
        for (String search : goodSearches) {
            PackResponse packResponse = tree.searchByPrefix(search);
            packResponseList.add(packResponse);
        }
        PackJson packJson = new PackJson(initTime, packResponseList);
        CreateJsonWithGson.create(packJson);

    }
}
