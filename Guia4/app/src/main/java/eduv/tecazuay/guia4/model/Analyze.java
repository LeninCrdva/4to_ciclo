package eduv.tecazuay.guia4.model;

public class Analyze {
    private String TextToAnalyze;
    private Boolean Successful;
    private String SentimentClassificationResult;
    private Number SentimentScoreResult;
    private Integer SentenceCount;

    public Analyze(String textToAnalyze, Boolean successful, String sentimentClassificationResult, Number sentimentScoreResult, Integer senteceCount) {
        TextToAnalyze = textToAnalyze;
        Successful = successful;
        SentimentClassificationResult = sentimentClassificationResult;
        SentimentScoreResult = sentimentScoreResult;
        SentenceCount = senteceCount;
    }

    public String getTextToAnalyze() {
        return TextToAnalyze;
    }

    public void setTextToAnalyze(String textToAnalyze) {
        TextToAnalyze = textToAnalyze;
    }

    public Boolean getSuccessful() {
        return Successful;
    }

    public void setSuccessful(Boolean successful) {
        Successful = successful;
    }

    public String getSentimentClassificationResult() {
        return SentimentClassificationResult;
    }

    public void setSentimentClassificationResult(String sentimentClassificationResult) {
        SentimentClassificationResult = sentimentClassificationResult;
    }

    public Number getSentimentScoreResult() {
        return SentimentScoreResult;
    }

    public void setSentimentScoreResult(Number sentimentScoreResult) {
        SentimentScoreResult = sentimentScoreResult;
    }

    public Integer getSenteceCount() {
        return SentenceCount;
    }

    public void setSenteceCount(Integer senteceCount) {
        SentenceCount = senteceCount;
    }
}
