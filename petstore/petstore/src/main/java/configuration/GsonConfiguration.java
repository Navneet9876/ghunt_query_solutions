package configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonConfiguration {

    private static Gson gson = null;

    public static Gson get() {
        if (gson == null)
            gson = new GsonBuilder().setPrettyPrinting().create();
        return gson;
    }

}
