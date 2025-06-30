package listpractice.set;

import java.util.Objects;

public class VotingSystem {

    private int voterId;
    private String name;

    public VotingSystem(int voterId, String name) {
        this.voterId = voterId;
        this.name = name;
    }

    public int getVoterId() {
        return voterId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VotingSystem that = (VotingSystem) o;
        return voterId == that.voterId && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voterId, name);
    }

    @Override
    public String toString() {
        return "VotingSystem{" +
                "voterId=" + voterId +
                ", name='" + name + '\'' +
                '}';
    }
}
