package creator.mvc.model.game.action;

import creator.mvc.model.game.player.target.SingleTarget;
import creator.mvc.model.game.player.target.Target;
import creator.mvc.model.setup.ability.Ability;

public class Action {
    private final SingleTarget source;
    private final Target target;
    private final Ability ability;
    private final boolean isFactional;

    protected Action(SingleTarget source, Target target, Ability ability, boolean isFactional) {
        this.source = source;
        this.target = target;
        this.ability = ability;
        this.isFactional = isFactional;
    }

    public SingleTarget getSource() {
        return source;
    }

    public Target getTarget() {
        return target;
    }

    public Ability getAbility() {
        return ability;
    }

    public boolean isFactional() {
        return isFactional;
    }
}
