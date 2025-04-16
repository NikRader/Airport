package createJSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class CreateJsonWithGson {
    public static void create(PackJson packJson){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("output_gson.json")) {
            gson.toJson(packJson, writer);
            System.out.println("Файл output_gson.json успешно создан: ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
