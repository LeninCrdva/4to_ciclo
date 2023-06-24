package eduv.tecazuay.guia4.model;

public class Entity {
    private String EntityType;
    private String EntityText;

    public Entity(String entityType, String entityText) {
        EntityType = entityType;
        EntityText = entityText;
    }

    public String getEntityType() {
        return EntityType;
    }

    public void setEntityType(String entityType) {
        EntityType = entityType;
    }

    public String getEntityText() {
        return EntityText;
    }

    public void setEntityText(String entityText) {
        EntityText = entityText;
    }
}
