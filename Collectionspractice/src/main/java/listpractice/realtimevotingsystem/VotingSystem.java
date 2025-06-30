package listpractice.realtimevotingsystem;
import java.util.*;
import java.util.stream.*;
import java.util.ArrayList;
import java.util.List;

public class VotingSystem {
    public static void main(String[] args) {
        List<Vote> votes = List.of(
                new Vote("user1", "Java"),
                new Vote("user2", "Python"),
                new Vote("user3", "Java"),
                new Vote("user4", "Go"),
                new Vote("user1", "C++"),      // Duplicate voter
                new Vote("user5", "Python")
        );


        Set<String> seenVoters = new HashSet<>();
        List<Vote> filteredVotes = votes.stream()
                .filter(vote -> seenVoters.add(vote.getVoterId()))
                .collect(Collectors.toList());


        Map<String, Long> frequencyMap = filteredVotes.stream()
                .collect(Collectors.groupingBy(Vote::getOption, Collectors.counting()));


        List<Map.Entry<String, Long>> sortedVotes = frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        System.out.println(" Sorted Voting Results:");
        sortedVotes.forEach(entry ->
                System.out.println(entry.getKey() + ": " + entry.getValue() + " votes")
        );
    }
}




