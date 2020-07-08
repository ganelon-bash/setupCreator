package creator.mvc.model;

import creator.mvc.model.game.Game;
import creator.mvc.model.game.player.GameCharacter;
import creator.mvc.model.game.player.Player;
import creator.mvc.model.setup.Setup;
import creator.mvc.model.setup.order.OrderOperations;
import creator.mvc.model.setup.role.Role;
import creator.mvc.model.setup.role.hidden.RoleSlot;
import creator.util.ReadOnlyList;

import java.util.ArrayList;
import java.util.Collections;

public class Bridge {
    private final Setup setup;
    private final ReadOnlyList<Role> roles;

    private final Game game;

    public Bridge(Setup setup, ArrayList<Player> players) {
        ArrayList<RoleSlot> roleSlots = setup.getSlots();
        ArrayList<Role> roles = new ArrayList<>(roleSlots.size());
        ArrayList<GameCharacter> characters = new ArrayList<>(players.size());

        this.setup = setup;
        this.roles = new ReadOnlyList<>(roles);
        OrderOperations orderOperations = setup.getOrderOperations();

        game = new Game(characters, players, orderOperations, setup.getPhaseOrder());

        roleSlots.forEach(rS -> {
            roles.add(rS.generate(this));
        });
        Collections.shuffle(roles);
        for(int i = 0; i < players.size(); i++){
            characters.add(new GameCharacter(game, players.get(0), roles.get(0), roles.get(0).getFaction()));
        }

    }

    public Game newGame(){
        return game;
    }

    public Setup getSetup() {
        return setup;
    }

    public ReadOnlyList<Role> getRoles() {
        return roles;
    }
}
