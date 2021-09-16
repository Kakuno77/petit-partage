import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;

public class Main {

    static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws Exception {
        System.out.println(":)");

        String json = run("https://pokeapi.co/api/v2/pokemon/ditto");
        System.out.println(json);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // Faiblement typé
        int xp = objectMapper.readTree(json).get("base_experience").asInt();
        Pokemon pok = new Pokemon();
        pok.setBaseExperience(objectMapper.readTree(json).get("base_experience").asInt());

        // Fortement typé
        Pokemon pokemon = objectMapper.readValue(json, Pokemon.class);
        System.out.println(pokemon.getBaseExperience());
        System.out.println(pokemon.getForms().length);

        objectMapper.writeValue(new File("pokemon.json"),pokemon);
    }

    public static String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
