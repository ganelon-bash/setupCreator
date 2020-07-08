package creator.mvc.model.game.util;

import creator.mvc.model.game.Game;

import java.util.function.Predicate;

@FunctionalInterface
public interface Condition extends Predicate<Game> {
}
