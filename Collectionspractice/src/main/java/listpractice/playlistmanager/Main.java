package listpractice;

public class Main {
    public static void main(String[] args) {

        PlayListManager p = new PlayListManager();

        p.addSong("shape of you");
        p.addSong("dreams");
        p.addSong("senorita");
        p.addIndex("memories come back",2);

        p.displayPlaylist();


        p.removeSong("dreams");

        p.moveIndex(2,1);

        p.displayPlaylist();

        p.reverseOrder();



        p.shuffle();
        System.out.println("after shuffle");
        p.displayPlaylist();


        p.reversePLaylist();
        System.out.println("after reversing");
        p.displayPlaylist();




    }
}
