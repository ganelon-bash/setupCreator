package creator.mvc.model.setup.role.hidden;

import creator.mvc.model.Bridge;
import creator.mvc.model.setup.Setup;
import creator.mvc.model.setup.SetupObject;
import creator.mvc.model.setup.role.Role;
import creator.util.ReadOnlyList;


public abstract class HiddenRole  {
    protected final Role role;

    public HiddenRole(Role role){
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public Role spawnRole(){
        return role.generateRole();
    }

    public abstract boolean canSpawn(Bridge bridge);
}
