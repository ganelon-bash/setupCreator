package creator.mvc.model.game.util;

import creator.mvc.model.game.Game;
import creator.mvc.model.game.player.GameCharacter;
import creator.mvc.model.game.player.Player;
import creator.mvc.model.game.player.target.Target;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public interface Feedback extends BiFunction<Game, GameCharacter, String> {
}
