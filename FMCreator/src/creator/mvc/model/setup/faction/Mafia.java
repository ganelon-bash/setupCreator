package creator.mvc.model.setup.faction;

import creator.mvc.model.game.player.GameCharacter;
import creator.mvc.model.game.util.Wincon;
import creator.mvc.model.setup.ability.Ability;
import creator.mvc.model.setup.ability.TargetedAbility;
import creator.mvc.model.setup.faction.pseudoenum.Cult;
import creator.mvc.model.setup.faction.pseudoenum.Killing;
import creator.mvc.model.setup.faction.pseudoenum.Neutral;

import java.awt.*;

public class Mafia extends EvilFaction {
    private static final Color mafiaColor = new Color(190, 30, 50);
    public Mafia(String name, String description, Ability ability, Wincon wincon, Color color) {
        super(name, description, ability, wincon, color);
    }

    public Mafia(){
        super("Mafia", "The uninformed minority. Can kill at night.", TargetedAbility.nightKill(), (g, f) -> {
            int totalCount = (int) g.stream().count();
            int ownCount = (int) g.stream().map(GameCharacter::getFaction)
                    .filter(fc -> fc.equals(f) || (fc instanceof Neutral && !(fc instanceof Cult || fc instanceof Killing))).count();
            return ownCount > (totalCount / 2);

        }, mafiaColor);
    }
}
