package QueryHandler;

import java.util.ArrayList;
import java.util.List;

public class QueryHandler {

    public static List<String> checkQuery(List<String> queries) {
        List<String> goodSearch = new ArrayList<>();
        if (queries == null) return goodSearch;
        for (String query : queries) {
            if (query != null && !query.trim().isEmpty()) {
                goodSearch.add(query.trim());
            }
        }
        return goodSearch;
    }


}