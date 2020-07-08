package creator.mvc.model.game.util;

import creator.mvc.model.game.Game;
import creator.mvc.model.game.player.GameCharacter;
import creator.mvc.model.game.player.target.Target;
import creator.mvc.model.setup.ability.TargetedAbility;

import java.util.function.BiConsumer;

@FunctionalInterface
public interface Effect extends BiConsumer<Game, GameCharacter> {
    Effect nightKill = (g, c) -> {
        c.attack(1);
    };
    Effect heal = (g, c) -> {
        c.heal(1);
    };
    Effect roleblock = (g, c) -> {
        c.set("roleBlocked", 1);
    };
}
