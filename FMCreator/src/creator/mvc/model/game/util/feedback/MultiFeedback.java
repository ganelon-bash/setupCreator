package creator.mvc.model.game.util.feedback;

import creator.mvc.model.game.Game;
import creator.mvc.model.game.player.GameCharacter;
import creator.mvc.model.game.util.Feedback;

import java.util.ArrayList;

public class MultiFeedback implements Feedback {
    private final ArrayList<Feedback> feedbacks;
    private int index = 0;

    public MultiFeedback(ArrayList<Feedback> Feedbacks){
        this.feedbacks = Feedbacks;
    }

    public void move(){
        index++;
    }

    public void retreat(){
        index--;
    }

    public void reset(){
        index = 0;
    }

    @Override
    public String apply(Game game, GameCharacter gameCharacter) {
        return feedbacks.get(index).apply(game, gameCharacter);
    }
}
