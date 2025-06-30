package listpractice.realtimevotingsystem;

public class Vote {

    private final String voterId;
    private final String option;

    public Vote(String voterId, String option) {
        this.voterId = voterId;
        this.option = option;
    }

    public String getVoterId() {
        return voterId;
    }

    public String getOption() {
        return option;
    }

    public String getName() {
    }
}


