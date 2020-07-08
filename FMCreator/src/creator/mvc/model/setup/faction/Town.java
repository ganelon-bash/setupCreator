package creator.mvc.model.setup.faction;

import creator.mvc.model.game.player.GameCharacter;
import creator.mvc.model.game.util.Wincon;
import creator.mvc.model.setup.ability.Ability;

import java.awt.*;

public class Town extends Faction {

    private static final Color townColor = new Color(40, 160, 70);
    public Town(String name, String description, Ability ability, Wincon wincon, Color color) {
        super(name, description, ability, wincon, color);
    }

    public Town(){
        this("Town", "The uninformed majority.", Ability.noAbility(),
                (g, f) -> g.stream().
                         map(GameCharacter::getFaction).filter(fc -> fc instanceof EvilFaction)
                         .count() <= 0,
                townColor);
    }
}
