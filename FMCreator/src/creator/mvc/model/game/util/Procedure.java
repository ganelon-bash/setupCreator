package creator.mvc.model.game.util;

import creator.mvc.model.game.Game;

import java.util.function.Consumer;

@FunctionalInterface
public interface Procedure extends Consumer<Game> {
}
