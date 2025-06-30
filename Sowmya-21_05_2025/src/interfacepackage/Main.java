package interfacepackage;

public class Main {
    public static void main(String[] args) {


        Playable mp3 = new MP3Player();
        Playable mp4 = new MP4Player();
        Playable avi = new AVIPlayer();

        mp3.play();
        mp3.stop();

        mp4.play();
        mp4.stop();

        avi.play();
        avi.stop();
    }
}
