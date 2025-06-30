package interfacepackage;

public class AVIPlayer implements Playable{
    @Override
    public void play() {

        System.out.println("AVI player is playing");

    }

    @Override
    public void stop() {

        System.out.println("AVI player is stopped");

    }
}
