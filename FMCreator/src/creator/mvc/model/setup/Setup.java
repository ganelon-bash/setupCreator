package creator.mvc.model.setup;

import creator.mvc.model.setup.faction.Faction;
import creator.mvc.model.setup.order.OrderOperations;
import creator.mvc.model.setup.phase.base.Phase;
import creator.mvc.model.setup.role.Role;
import creator.mvc.model.setup.role.hidden.RoleSlot;

import java.util.ArrayList;

public class Setup {
    private final ArrayList<Faction> factions;
    private final ArrayList<Role> possibleRoles;
    private final ArrayList<RoleSlot> slots;
    private final OrderOperations orderOperations;

    private final ArrayList<Phase> phaseOrder;

    public Setup(ArrayList<Faction> factions, ArrayList<Role> possibleRoles,
                 ArrayList<RoleSlot> slots, ArrayList<Phase> phaseOrder,
                 OrderOperations orderOperations
                 ) {
        this.factions = factions;
        this.possibleRoles = possibleRoles;
        this.slots = slots;
        this.phaseOrder = phaseOrder;
        this.orderOperations = orderOperations;
    }

    public ArrayList<Faction> getFactions() {
        return factions;
    }

    public ArrayList<Role> getPossibleRoles() {
        return possibleRoles;
    }

    public ArrayList<RoleSlot> getSlots() {
        return slots;
    }

    public ArrayList<Phase> getPhaseOrder() {
        return phaseOrder;
    }

    public OrderOperations getOrderOperations() {
        return orderOperations;
    }
}
