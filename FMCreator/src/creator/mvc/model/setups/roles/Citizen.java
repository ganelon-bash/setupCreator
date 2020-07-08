package creator.mvc.model.setups.roles;

import creator.mvc.model.setup.ability.Ability;
import creator.mvc.model.setup.faction.Town;
import creator.mvc.model.setup.role.Role;

public class Citizen extends Role {
    public Citizen(String name, String description, Town town){
        super(name, description, town, Ability.noAbility(), 1);
    }

    public Citizen(Town town){
        this("Citizen", "A law-abiding citizen with the power of the vote.", town);
    }

    @Override
    public Role generateRole() {
        return new Citizen(name, description, (Town) faction);
    }
}
