package creator.mvc.model.game;

public abstract class GameObject {
    protected final Game game;

    public GameObject(Game game){
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
}
