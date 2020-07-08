package creator.mvc.model.game.util.effect;

import creator.mvc.model.game.Game;
import creator.mvc.model.game.player.GameCharacter;
import creator.mvc.model.game.util.Effect;

import java.util.ArrayList;

public class MultiEffect implements Effect {
    private final ArrayList<Effect> effects;
    private int index = 0;

    public MultiEffect(ArrayList<Effect> effects){
        this.effects = effects;
    }

    public int getIndex(){
        return index;
    }
    public void setIndex(int index){
        this.index = index;
    }

    @Override
    public void accept(Game game, GameCharacter gameCharacter) {
        effects.get(index).accept(game, gameCharacter);
    }
}
