package creator.mvc.model.setup.role.hidden;

import creator.mvc.model.Bridge;
import creator.mvc.model.setup.Setup;
import creator.mvc.model.setup.role.Role;
import creator.util.Random;
import creator.util.ReadOnlyList;

import java.util.ArrayList;

public class RoleSlot {
    private final ArrayList<HiddenRole> hiddenRoles;


    public RoleSlot(ArrayList<HiddenRole> hiddenRoles){
        this.hiddenRoles = hiddenRoles;
    }

    public Role generate(Bridge bridge){
        HiddenRole hiddenRole = null;

        while(hiddenRole == null || !hiddenRole.canSpawn(bridge)){
            hiddenRole = Random.randomValue(hiddenRoles);
        }
        return hiddenRole.spawnRole();
    }
}
