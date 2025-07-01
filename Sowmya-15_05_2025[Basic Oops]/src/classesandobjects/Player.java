package classesandobjects;

public class Player {
        int playerId;
        String playerName;

        public void setPlayerData(int id, String name)
        {
            playerId = id;
            playerName = name;
        }

        public void getPlayerData()
        {
            System.out.println("Player Id is :"+playerId);
            System.out.println("Player Name is :"+playerName);
        }

    }

