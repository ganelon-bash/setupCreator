package creator.mvc.model.game.player.target;

import creator.mvc.model.game.Game;
import creator.mvc.model.game.player.GameCharacter;
import creator.mvc.model.game.util.Effect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class MultiTarget extends Target {
    private final ArrayList<GameCharacter> characters;

    public MultiTarget(Game game, GameCharacter... gameCharacters){
        super(game);
        characters = new ArrayList<>(gameCharacters.length);
        characters.addAll(Arrays.asList(gameCharacters));
    }

    @Override
    public void affect(Effect effect) {
        characters.forEach(c -> effect.accept(game, c));
    }

    public void setCharacters(GameCharacter... gameCharacters){
        characters.clear();
        characters.addAll(Arrays.asList(gameCharacters));
    }

    public void setCharacters(Stream<GameCharacter> stream){
        characters.clear();
        stream.forEach(this::addTarget);
    }

    public ArrayList<GameCharacter> getCharacters() {
        return characters;
    }

    public void addTarget(GameCharacter gameCharacter){
        characters.add(gameCharacter);
    }

    public void removeTarget(GameCharacter gameCharacter){
        characters.remove(gameCharacter);
    }
}
