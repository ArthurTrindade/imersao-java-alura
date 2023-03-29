import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClientHttp {

    public String getBody(String url) {

        try {
            // Fazendo o URI da URL
            URI uri = URI.create(url);

            // variavel com client HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Fazendo a requisição HTTP (GET)
            HttpRequest req = HttpRequest.newBuilder(uri).GET().build();

            // Executando a requisição HTTP sendo devolvida em string
            HttpResponse<String> response;
            response = client.send(req, BodyHandlers.ofString());

            String body = response.body();
            return body;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } 
    }
}
