package creator.mvc.model.setup.election;

import creator.mvc.model.game.player.GameCharacter;

import java.util.ArrayList;
import java.util.stream.Stream;

public abstract class VotingSystem {

    public abstract Stream<GameCharacter> getWinners(ArrayList<Vote> votes, ArrayList<GameCharacter> characters);
    public abstract boolean electionHasOccurred(ArrayList<Vote> votes, ArrayList<GameCharacter> characters);
}
