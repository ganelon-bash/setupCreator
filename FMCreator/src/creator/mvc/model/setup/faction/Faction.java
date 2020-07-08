package creator.mvc.model.setup.faction;

import creator.mvc.model.game.Game;
import creator.mvc.model.game.util.Condition;
import creator.mvc.model.game.util.Wincon;
import creator.mvc.model.setup.Actable;
import creator.mvc.model.setup.SetupObject;
import creator.mvc.model.setup.ability.Ability;

import java.awt.*;
import java.util.function.Predicate;

public abstract class Faction extends SetupObject implements Actable {
    protected final Ability ability;
    protected final Wincon wincon;
    protected final Color color;

    public Faction(String name, String description, Ability ability, Wincon wincon, Color color) {
        super(name, description);

        this.ability = ability;
        this.wincon = wincon;
        this.color = color;
    }
}
