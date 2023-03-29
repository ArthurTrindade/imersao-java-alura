import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractorImageNasa implements ExtractorImage {

    public List<Image> getImages(String json) {

        /* Parseando os dados de body */
        var parser = new JsonParser();
        List<Map<String, String>> listAttributes = parser.parse(json); 
        
        List<Image> images = new ArrayList<>();

        for (Map<String, String> attributes: listAttributes) {
            String title = attributes.get("title");
            String urlImage = attributes.get("url"); 

            var Image = new Image(title, urlImage);
            images.add(Image);
        }

        return images;
    }

}
