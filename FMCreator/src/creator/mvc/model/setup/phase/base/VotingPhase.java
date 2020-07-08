package creator.mvc.model.setup.phase.base;

import creator.mvc.model.setup.election.VotingSystem;

public abstract class VotingPhase extends Phase{

    protected final VotingSystem votingSystem;

    public VotingPhase(long duration, long count, boolean discussionEnabled, VotingSystem votingSystem) {
        super(duration, count, discussionEnabled);
        this.votingSystem = votingSystem;
    }

    @Override
    public boolean canVote() {
        return true;
    }

    public VotingSystem getVotingSystem() {
        return votingSystem;
    }
}
