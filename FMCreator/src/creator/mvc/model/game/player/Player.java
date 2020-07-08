package creator.mvc.model.game.player;

import java.util.HashMap;
import java.util.Objects;

import creator.util.Random;

public class Player {
    private final String name;
    private final int ID;

    private static final Player dummyPlayer = new Player("Dummy", 0);

    public Player(String name, int ID){
        this.name = name;
        this.ID = ID;
    }
    public Player(String name, HashMap<Integer, String> IDs){
        int v = 0;
        while(IDs.containsKey(v))
        {
            v = Random.randomInt(1, Short.MAX_VALUE * 2);
        }
        this.ID = v;
        this.name = name;

        IDs.put(ID, name);
    }

    public static Player getDummyPlayer() {
        return dummyPlayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return ID == player.ID &&
                name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ID);
    }
}
