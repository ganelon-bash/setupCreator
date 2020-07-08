package creator.mvc.model.setup.phase;

import creator.mvc.model.setup.election.VotingSystem;
import creator.mvc.model.setup.phase.base.Phase;
import creator.mvc.model.setup.phase.base.VotingPhase;

public class VotingMorning extends VotingPhase {
    public VotingMorning(long duration, long count, VotingSystem votingSystem) {
        super(duration, count, true, votingSystem);
    }

    @Override
    public Phase generatePhase(int i) {
        return new VotingMorning(duration, i, votingSystem);
    }
}
