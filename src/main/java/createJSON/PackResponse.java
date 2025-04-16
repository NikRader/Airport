package createJSON;
import java.util.List;

public class PackResponse {
    public String search;
    public List<String> result;
    public int time;

    public PackResponse(String search, List<String> result, int time) {
        this.search = search;
        this.result = result;
        this.time = time;
    }
}
