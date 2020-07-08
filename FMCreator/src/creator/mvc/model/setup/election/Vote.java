package creator.mvc.model.setup.election;

import creator.mvc.model.game.Game;
import creator.mvc.model.game.player.GameCharacter;
import creator.mvc.model.game.player.Player;

import java.util.ArrayList;

public class Vote {
    private final ArrayList<GameCharacter> targets;

    public Vote(ArrayList<GameCharacter> targets){
        this.targets = targets;
    }

    public ArrayList<GameCharacter> getTargets() {
        return targets;
    }
}
