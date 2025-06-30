package interfacepackage;

public class MP3Player implements Playable{
    @Override
    public void play() {

        System.out.println("Mp3 player is playing");

    }

    @Override
    public void stop() {

        System.out.println("Mp4 player is stopped");

    }
}
