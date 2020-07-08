package creator.mvc.model.setup.phase.base;

import java.util.Timer;
import java.util.TimerTask;

public abstract class Phase {
    protected final long duration, count;
    private final boolean discussionEnabled;
    private Thread thread;

    public Phase(long duration, long count, boolean discussionEnabled){
        this.duration = duration;
        this.count = count;
        this.discussionEnabled = discussionEnabled;
    }

    public long getDuration() {
        return duration;
    }

    public long getCount() {
        return count;
    }

    public boolean isDiscussionEnabled() {
        return discussionEnabled;
    }

    public boolean canVote(){
        return false;
    }

    public void end(){
        thread.interrupt();
    }

    public abstract void run();

    public void execute(){
        Runnable runnable = this::run;
        thread = new Thread(runnable);
    }

    public abstract Phase generatePhase(int i);

    public void start(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                end();
            }
        }, duration);
        execute();
    }
}
