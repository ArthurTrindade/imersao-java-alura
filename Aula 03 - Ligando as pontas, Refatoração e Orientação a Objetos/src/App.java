import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // url da API
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";

        var http = new ClientHttp();

        String json = http.getBody(url);

        ExtractorImage extractorImagesIMDB = new ExtractorImageIMDB();
        List<Image> imagesIMDB = extractorImagesIMDB.getImages(json);

        var stickets = new StickerGenerator();

        for (Image image : imagesIMDB) {

            InputStream inputStream = new URL(image.urlImage()).openStream();
            String nomeArquivo = image.title() + ".png";

            stickets.createSticker(inputStream, nomeArquivo);

            System.out.println(image.title());

        }
    }
}
