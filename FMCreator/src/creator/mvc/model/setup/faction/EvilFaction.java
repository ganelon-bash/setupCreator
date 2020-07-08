package creator.mvc.model.setup.faction;

import creator.mvc.model.game.util.Wincon;
import creator.mvc.model.setup.ability.Ability;

import java.awt.*;

public abstract class EvilFaction extends Faction{
    public EvilFaction(String name, String description, Ability ability, Wincon wincon, Color color) {
        super(name, description, ability, wincon, color);
    }
}
