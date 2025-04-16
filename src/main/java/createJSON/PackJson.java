package createJSON;
import java.util.List;

public class PackJson {
    public int initTime;
    public List<PackResponse> result;

    public PackJson(int initTime, List<PackResponse> result) {
        this.initTime = initTime;
        this.result = result;
    }
}
