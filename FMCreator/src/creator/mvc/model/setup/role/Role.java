package creator.mvc.model.setup.role;

import creator.mvc.model.setup.Actable;
import creator.mvc.model.setup.SetupObject;
import creator.mvc.model.setup.ability.Ability;
import creator.mvc.model.setup.faction.Faction;

import java.util.Objects;

public abstract class Role extends SetupObject implements Actable {

    protected final Faction faction;
    protected final Ability ability;
    protected final int defenseValue;

    public Role(String name, String description, Faction faction, Ability ability, int defenseValue) {
        super(name, description);
        this.faction = faction;
        this.ability = ability;
        this.defenseValue = defenseValue;
    }

    public Role(Role other){
        this(other.name, other.description, other.faction, other.ability, other.defenseValue);
    }

    public Faction getFaction() {
        return faction;
    }

    public Ability getAbility() {
        return ability;
    }

    public int getDefenseValue() {
        return defenseValue;
    }

    public abstract Role generateRole();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return name.equals(role.name) &&
                description.equals(role.description) &&
                defenseValue == role.defenseValue &&
                faction.equals(role.faction) &&
                ability.equals(role.ability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, faction, ability, defenseValue);
    }
}
