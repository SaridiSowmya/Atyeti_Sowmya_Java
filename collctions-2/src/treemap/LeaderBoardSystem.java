package treemap;
import java.util.*;

public class LeaderBoardSystem {

    private final TreeMap<Integer, List<String>> leaderboard = new TreeMap<>(Collections.reverseOrder());

    public void addScore(String playerName, int score) {
        leaderboard.computeIfAbsent(score, k -> new ArrayList<>()).add(playerName);
    }

    public void displayLeaderboard() {
        int rank = 1;
        for (Map.Entry<Integer, List<String>> entry : leaderboard.entrySet()) {
            int score = entry.getKey();
            List<String> players = entry.getValue();
            for (String player : players) {
                System.out.printf("Rank %d: %s → %d pts\n", rank, player, score);
            }
            rank += players.size();
        }
    }
}





