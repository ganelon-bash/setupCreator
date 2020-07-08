package creator.mvc.model.setup.ability;

import creator.mvc.model.game.Game;
import creator.mvc.model.game.player.target.Target;
import creator.mvc.model.game.util.Effect;
import creator.mvc.model.game.util.Feedback;

public class MultiTargetAbility extends Ability {
    public MultiTargetAbility(String name, String description, Effect action, Feedback feedback, int charges) {
        super(name, description, action, feedback, charges);
    }

    @Override
    public void run(Game game, Target t) {
        t.affect(action);
    }
}
