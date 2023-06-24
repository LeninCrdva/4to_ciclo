package eduv.tecazuay.guia4.model;

public class Languaje {
    private String textToDetect;
    private Boolean Successful;
    private String DetectedLanguage_ThreeLetterCode;
    private String DetectedLanguage_FullName;

    public Languaje(String textToDetect, Boolean successful, String detectedLanguage_ThreeLetterCode, String detectedLanguage_FullName) {
        this.textToDetect = textToDetect;
        Successful = successful;
        DetectedLanguage_ThreeLetterCode = detectedLanguage_ThreeLetterCode;
        DetectedLanguage_FullName = detectedLanguage_FullName;
    }

    public String getTextToDetect() {
        return textToDetect;
    }

    public void setTextToDetect(String textToDetect) {
        this.textToDetect = textToDetect;
    }

    public Boolean getSuccessful() {
        return Successful;
    }

    public void setSuccessful(Boolean successful) {
        Successful = successful;
    }

    public String getDetectedLanguage_ThreeLetterCode() {
        return DetectedLanguage_ThreeLetterCode;
    }

    public void setDetectedLanguage_ThreeLetterCode(String detectedLanguage_ThreeLetterCode) {
        DetectedLanguage_ThreeLetterCode = detectedLanguage_ThreeLetterCode;
    }

    public String getDetectedLanguage_FullName() {
        return DetectedLanguage_FullName;
    }

    public void setDetectedLanguage_FullName(String detectedLanguage_FullName) {
        DetectedLanguage_FullName = detectedLanguage_FullName;
    }
}
