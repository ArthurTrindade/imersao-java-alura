import java.util.List;
import java.util.Map;

public class ExtractorImageIMDB implements ExtractorImage {

    public List<Image> getImages(String json) {

        /* Parseando os dados de body */
        var parser = new JsonParser();
        List<Map<String, String>> listAttributes = parser.parse(json); 

        return listAttributes.stream()
            .map(attributes -> new Image(attributes.get("title"), attributes.get("image")))
            .toList();    
        
    }
}
