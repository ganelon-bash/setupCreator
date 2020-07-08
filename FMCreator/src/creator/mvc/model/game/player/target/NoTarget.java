package creator.mvc.model.game.player.target;

import creator.mvc.model.game.Game;
import creator.mvc.model.game.util.Effect;

public class NoTarget extends Target {
    @Override
    public void affect(Effect effect) {
        effect.accept(game, game.getNoCharacter());
    }

    public NoTarget(Game game) {
        super(game);
    }
}
