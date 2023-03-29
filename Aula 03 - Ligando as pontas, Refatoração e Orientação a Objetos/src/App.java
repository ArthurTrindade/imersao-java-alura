import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // url da API
        API api = API.IMDB;

        String url = api.getUrl();
        ExtractorImage extractorImages = api.getExtractor();
        
        var http = new ClientHttp();

        String json = http.getBody(url);

        List<Image> imagesIMDB = extractorImages.getImages(json);

        var stickets = new StickerGenerator();

        for (Image image : imagesIMDB) {

            InputStream inputStream = new URL(image.urlImage()).openStream();
            String nomeArquivo = image.title() + ".png";

            stickets.createSticker(inputStream, nomeArquivo);

            System.out.println(image.title());

        }
    }
}
