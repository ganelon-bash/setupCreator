package creator.mvc.model.game.player.target;


import creator.mvc.model.game.Game;
import creator.mvc.model.game.player.GameCharacter;
import creator.mvc.model.game.util.Effect;

public class SingleTarget extends Target {
    private GameCharacter character;

    public SingleTarget(Game game, GameCharacter gameCharacter){
        super(game);
        this.character = gameCharacter;
    }

    @Override
    public void affect(Effect effect) {
        effect.accept(game, character);
    }

    public GameCharacter getCharacter() {
        return character;
    }

    public void setCharacter(GameCharacter character) {
        this.character = character;
    }

}
