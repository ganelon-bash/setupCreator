package creator.mvc.model.setup.role.hidden;

import creator.mvc.model.Bridge;
import creator.mvc.model.setup.Setup;
import creator.mvc.model.setup.role.Role;
import creator.util.ReadOnlyList;

public class UniqueRole extends HiddenRole {

    public UniqueRole(Role role) {
        super(role);
    }

    @Override
    public boolean canSpawn(Bridge bridge) {
        return bridge.getRoles().stream().noneMatch(r -> r.equals(role));
    }
}
