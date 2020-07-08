package creator.mvc.model.setup.role.hidden;

import creator.mvc.model.Bridge;
import creator.mvc.model.setup.role.Role;
import creator.util.ReadOnlyList;

public class RegularRole extends HiddenRole {
    public RegularRole(Role role) {
        super(role);
    }

    @Override
    public boolean canSpawn(Bridge bridge) {
        return true;
    }
}
