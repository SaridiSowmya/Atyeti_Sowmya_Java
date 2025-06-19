package treemap;

public class Main {
    public static void main(String[] args) {

        LeaderBoardSystem lb = new LeaderBoardSystem();
        lb.addScore("Alice", 95);
        lb.addScore("Bob", 80);
        lb.addScore("Charlie", 95);
        lb.addScore("Diana", 70);
        lb.addScore("Eve", 80);

        lb.displayLeaderboard();
    }
}

