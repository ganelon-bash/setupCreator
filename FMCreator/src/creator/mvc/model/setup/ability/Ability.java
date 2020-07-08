package creator.mvc.model.setup.ability;

import creator.mvc.model.game.Game;
import creator.mvc.model.game.player.GameCharacter;
import creator.mvc.model.game.player.target.Target;
import creator.mvc.model.game.util.Effect;
import creator.mvc.model.game.util.Feedback;
import creator.mvc.model.game.util.Procedure;
import creator.mvc.model.setup.SetupObject;

import java.util.Objects;
import java.util.function.Consumer;

public abstract class Ability extends SetupObject {
    protected final Effect action;
    protected final Feedback feedback;
    protected final int maxCharges;
    protected int charges;

    protected final boolean useAtDay;
    protected final boolean useAtNight;

    public Ability(String name, String description, Effect action, Feedback feedback, int charges) {
        super(name, description);
        this.action = action;
        this.feedback = feedback;
        this.maxCharges = charges;
        this.charges = charges;
        this.useAtDay = false;
        this.useAtNight = true;
    }

    public Effect getAction() {
        return action;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public int getMaxCharges() {
        return maxCharges;
    }

    public int getCharges() {
        return charges;
    }

    public void useUpCharge(){
        charges--;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

    private static final Ability noAbility = new Ability("Nothing", "None.", (g, p) -> {}, (g, p) -> "", 0) {
        @Override
        public void run(Game game, Target t) {

        }
    };

    public static Ability noAbility(){
        return noAbility;
    }

    public abstract void run(Game game, Target t);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ability ability = (Ability) o;
        return maxCharges == ability.maxCharges &&
                charges == ability.charges &&
                Objects.equals(action, ability.action) &&
                Objects.equals(feedback, ability.feedback);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, feedback, maxCharges, charges);
    }
}
