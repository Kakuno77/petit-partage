import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {

    static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws Exception {
        System.out.println(":)");

        System.out.println(run("https://pokeapi.co/api/v2/pokemon/ditto"));
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
