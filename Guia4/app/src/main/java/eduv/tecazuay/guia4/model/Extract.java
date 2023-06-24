package eduv.tecazuay.guia4.model;

public class Extract {
    private String InputString;
    private Boolean Successful;
    private Entity[] Entities;

    public Extract(String inputString, Boolean successful, Entity[] entities) {
        InputString = inputString;
        Successful = successful;
        Entities = entities;
    }

    public String getInputString() {
        return InputString;
    }

    public void setInputString(String inputString) {
        InputString = inputString;
    }

    public Boolean getSuccessful() {
        return Successful;
    }

    public void setSuccessful(Boolean successful) {
        Successful = successful;
    }

    public Entity[] getEntities() {
        return Entities;
    }

    public void setEntities(Entity[] entities) {
        Entities = entities;
    }
}
