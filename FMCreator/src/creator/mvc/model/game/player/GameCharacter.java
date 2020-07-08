package creator.mvc.model.game.player;

import creator.mvc.model.game.Constants;
import creator.mvc.model.game.Game;
import creator.mvc.model.game.GameObject;
import creator.mvc.model.setup.faction.Faction;
import creator.mvc.model.setup.role.Role;

import java.util.HashMap;

public class GameCharacter extends GameObject {
    private final Player player;

    private Role role;
    private Faction faction;
    private String lastWill, deathNote;

    private final HashMap<String, Modifier> modifiers = new HashMap<>();

    private int defenseValue;

    public static GameCharacter noCharacter(Game game){
        if(game.getNoCharacter() == null){
            game.setNoCharacter(new GameCharacter(game, Player.getDummyPlayer()));
        }
        return game.getNoCharacter();
    }

    public GameCharacter(Game game, Player player){
        super(game);
        this.player = player;
        this.lastWill = "";
        this.deathNote = null;
    }

    public GameCharacter(Game game, Player player, Role role, Faction faction){
        this(game, player);
        this.role = role;
        this.faction = faction;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public boolean isAlive(){
        return defenseValue > 0 || defenseValue == Constants.Immortal;
    }

    public String getLastWill() {
        return lastWill;
    }

    public void setLastWill(String lastWill) {
        this.lastWill = lastWill;
    }

    public String getDeathNote() {
        return deathNote;
    }

    public void setDeathNote(String deathNote) {
        this.deathNote = deathNote;
    }

    public Player getPlayer() {
        return player;
    }


    public void setDefenseValue(int value){
        this.defenseValue = value;
    }

    public void attack(int value){
        if(this.defenseValue == Constants.Immortal || this.defenseValue == Constants.PermanentlyDead){
            return;
        }
        this.defenseValue -= value;
    }

    public void heal(int value){
        if(this.defenseValue == Constants.Immortal || this.defenseValue == Constants.PermanentlyDead){
            return;
        }
        this.defenseValue += value;
    }

    public void kill(){
        setDefenseValue(Constants.PermanentlyDead);
    }

    public void set(String name, int value){
        Modifier modifier = modifiers.getOrDefault(name, null);
        if(modifier == null){
            modifier = new Modifier(value);
            modifiers.put(name, modifier);
        }else{
            modifier.setValue(value);
        }
    }
    public int get(String name) {
        if (modifiers.containsKey(name)) {
            return modifiers.get(name).getValue();
        }else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof GameCharacter){
            GameCharacter other = (GameCharacter) obj;
            return other.player.equals(player);
        }
        return false;
    }
}
