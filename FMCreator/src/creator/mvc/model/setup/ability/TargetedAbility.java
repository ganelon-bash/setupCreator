package creator.mvc.model.setup.ability;

import creator.mvc.model.game.Constants;
import creator.mvc.model.game.Game;
import creator.mvc.model.game.player.target.Target;
import creator.mvc.model.game.util.Effect;
import creator.mvc.model.game.util.Feedback;

public class TargetedAbility extends Ability {
    public TargetedAbility(String name, String description, Effect action, Feedback feedback, int charges) {
        super(name, description, action, feedback, charges);
    }

    private static final TargetedAbility factionalKill = new TargetedAbility("Factional Kill", "Attack a target at night, lowering their defense value by 1.",
            Effect.nightKill, (g, c) -> "", Constants.Unlimited);

    public static TargetedAbility nightKill(){
        return factionalKill;
    }

    @Override
    public void run(Game game, Target t) {
        t.affect(action);
    }
}
