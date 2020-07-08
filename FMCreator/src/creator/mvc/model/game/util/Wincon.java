package creator.mvc.model.game.util;

import creator.mvc.model.game.Game;
import creator.mvc.model.setup.faction.Faction;

import java.util.function.BiPredicate;

@FunctionalInterface
public interface Wincon extends BiPredicate<Game, Faction> {
}
