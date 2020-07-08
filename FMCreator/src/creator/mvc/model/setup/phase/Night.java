package creator.mvc.model.setup.phase;

import creator.mvc.model.setup.phase.base.Phase;

public class Night extends Phase {
    public Night(long duration, long count) {
        super(duration, count, false);
    }

    @Override
    public Phase generatePhase(int i) {
        return new Night(duration, i);
    }

    @Override
    public void run() {

    }
}
