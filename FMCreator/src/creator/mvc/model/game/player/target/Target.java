package creator.mvc.model.game.player.target;

import creator.mvc.model.game.Game;
import creator.mvc.model.game.GameObject;
import creator.mvc.model.game.util.Effect;

public abstract class Target extends GameObject {
    public abstract void affect(Effect effect);

    public Target(Game game){
        super(game);
    }
}
