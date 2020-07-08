package creator.mvc.model.setup.ability;

import creator.mvc.model.game.Game;
import creator.mvc.model.game.player.target.MultiTarget;
import creator.mvc.model.game.player.target.Target;
import creator.mvc.model.game.util.Effect;
import creator.mvc.model.game.util.Feedback;
import creator.mvc.model.game.util.effect.MultiEffect;

public class MultiSpecialAbility extends Ability {
    public MultiSpecialAbility(String name, String description, MultiEffect action, Feedback feedback, int charges) {
        super(name, description, action, feedback, charges);
    }

    @Override
    public void run(Game game, Target t) {
        MultiTarget mT = (MultiTarget) t;
        MultiEffect mE = (MultiEffect) action;
        for(int i = 0; i < mT.getCharacters().size(); i++) {
            mE.setIndex(i);
            mE.accept(game, mT.getCharacters().get(i));
        }
    }
}
