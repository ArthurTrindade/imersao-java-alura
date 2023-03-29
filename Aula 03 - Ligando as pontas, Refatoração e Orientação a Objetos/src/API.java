public enum API {
    IMDB("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json", new ExtractorImageIMDB());

    private String url;
    private ExtractorImage extractor;

    API(String url, ExtractorImage extractor) {
        this.url = url;
        this.extractor = extractor;
    }

    public String getUrl() {
        return url;
    }

    public ExtractorImage getExtractor() {
        return extractor;
    }
}
