package listpractice.set;

import listpractice.realtimevotingsystem.Vote;

import java.util.HashSet;
import java.util.Set;

public class VotingSystemService {
    public static void main(String[] args) {

        Vote[] votes = {
                new Vote("V101", "Alice"),
                new Vote("V102", "Bob"),
                new Vote("V103", "Charlie"),
                new Vote("V101", "Alice"),
                new Vote("V102", "Bob"),
                new Vote("V104", "Diana")
        };

        Set<Vote> uniqueVoters = new HashSet<>();
        int totalVotes = 0;
        int duplicateVotes = 0;

        for (Vote voter : votes) {
            totalVotes++;
            if (!uniqueVoters.add(voter)) {
                System.out.println("Duplicate vote attempt detected from: " + voter.getName());
                duplicateVotes++;
            }
        }

        System.out.println("\n===== Voting Summary =====");
        System.out.println("Total voting attempts: " + totalVotes);
        System.out.println("Unique voters: " + uniqueVoters.size());
        System.out.println("Duplicate attempts: " + duplicateVotes);
    }
}



