package creator.mvc.model.setup;

public abstract class SetupObject {
    protected final String name, description;

    public SetupObject(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
