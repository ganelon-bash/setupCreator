package creator.mvc.model.game;

import creator.mvc.model.Bridge;
import creator.mvc.model.game.action.Action;
import creator.mvc.model.game.player.GameCharacter;
import creator.mvc.model.game.player.Player;
import creator.mvc.model.game.util.Effect;
import creator.mvc.model.setup.Actable;
import creator.mvc.model.setup.ability.Ability;
import creator.mvc.model.setup.faction.Faction;
import creator.mvc.model.setup.order.OrderOperations;
import creator.mvc.model.setup.phase.base.Phase;
import creator.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class Game {
    private GameCharacter noCharacter;

    private final ArrayList<GameCharacter> characters;
    private final ArrayList<Player> players;

    private final OrderOperations orderOperations;
    private final ArrayList<Phase> phaseOrder;

    private Phase currentPhase;
    private final ArrayList<Action> actions = new ArrayList<>();
    private final HashMap<Phase, ArrayList<Action>> history = new HashMap<>();

    public Game(ArrayList<GameCharacter> characters, ArrayList<Player> players, OrderOperations orderOperations, ArrayList<Phase> phaseOrder){
        this.characters = characters;
        this.players = players;
        this.orderOperations = orderOperations;
        this.phaseOrder = phaseOrder;

        this.currentPhase = phaseOrder.get(0).generatePhase(0);
    }

    public GameCharacter getNoCharacter() {
        return noCharacter;
    }

    public void setNoCharacter(GameCharacter noCharacter) {
        this.noCharacter = noCharacter;
    }

    public Stream<GameCharacter> stream(){
        return characters.stream();
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public HashMap<Phase, ArrayList<Action>> getHistory() {
        return history;
    }

    public Phase getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentPhase(Phase currentPhase) {
        this.currentPhase = currentPhase;
    }

    public ArrayList<Phase> getPhaseOrder() {
        return phaseOrder;
    }

    public OrderOperations getOrderOperations() {
        return orderOperations;
    }

    public void runActions(){
        actions.sort((a1, a2) -> {

            GameCharacter s1 = a1.getSource().getCharacter();
            GameCharacter s2 = a2.getSource().getCharacter();

            Faction f1 = s1.getFaction();
            Faction f2 = s2.getFaction();

            Ability b1 = a1.getAbility();
            Ability b2 = a2.getAbility();

            Actable c1 = s1.getRole();
            Actable c2 = s2.getRole();

            if(a1.isFactional()){
                c1 = f1;
            }
            if(a2.isFactional()){
                c2 = f2;
            }

            return orderOperations.indexOf(c1, b1) - orderOperations.indexOf(c2, b2);
        });
        actions.forEach(action -> {
            GameCharacter source = action.getSource().getCharacter();
            if(source.get("blocked") == 0 && source.isAlive()){
                Ability ability = action.getAbility();
                ability.run(this, action.getTarget());
            }
        });
        history.put(currentPhase, new ArrayList<>(actions));
    }

    public void run(){
        currentPhase.start();
    }
}
