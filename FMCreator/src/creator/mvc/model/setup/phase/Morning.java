package creator.mvc.model.setup.phase;

import creator.mvc.model.setup.phase.base.Phase;

public class Morning extends Phase {
    public Morning(long duration, long count) {
        super(duration, count, true);
    }

    @Override
    public Phase generatePhase(int i) {
        return new Morning(duration, i);
    }

    @Override
    public void run() {

    }
}
