import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // url da API
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";

        // Fazendo o URI da URL
        URI uri = URI.create(url);

        // variavel com client HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Fazendo a requisição HTTP (GET)
        HttpRequest req = HttpRequest.newBuilder(uri).GET().build();
    
        // Executando a requisição HTTP sendo devolvida em string
        HttpResponse<String> response = client.send(req, BodyHandlers.ofString());

        String body = response.body();

        // System.out.println(body);

        /* Parseando os dados de body */
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body); 

        /* Exibindo a API */
        for (Map<String, String> filme : listaDeFilmes) {
            printFormattedMovies(filme);
        }
    }

    static void printFormattedMovies(Map<String, String> movie) {
        System.out.println(String.format("\u001b[1m %s \u001b[0m", movie.get("title")));
        String rating = movie.get("imDbRating");
        System.out.println(String.format("Notas: \u001b[32m %s \u001b[0m", rating));

        var r = ((int)Double.parseDouble(rating));
        for (int i = 0; i < r; i++) {
            System.out.print("\uD83D\uDC99");
        }

        System.out.println();
        System.out.println();
    }
}
