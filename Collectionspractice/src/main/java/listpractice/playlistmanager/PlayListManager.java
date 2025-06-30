package listpractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class PlayListManager {
    private List<Song> playlist;

    public PlayListManager() {
        playlist = Collections.synchronizedList(new ArrayList<>());
    }

    public void addSong(String title)
    {
        playlist.add(new Song(title));
    }

    public void addIndex(String title,int index) {
        if (index > 0 && index <= playlist.size()) {
            playlist.add(index, new Song(title));
        } else {
            System.out.println("invalid index");
        }
    }

    public void removeSong(String title)
    {
            playlist.removeIf(song -> song.toString().equals(title));
    }

    public void moveIndex(int fromIndex,int toIndex)
    {
        if (fromIndex >= 0 && fromIndex < playlist.size() &&
                toIndex >= 0 && toIndex <= playlist.size()) {

            Song song = playlist.remove(fromIndex);
            playlist.add(toIndex, song);
        }
        else
        {
            System.out.println("Invalid indexes.");
        }
    }

    public void displayPlaylist()
    {
        synchronized (playlist)
        {
            System.out.println("playlist");
            for(Song song:playlist)
            {
                System.out.println(song);
            }
        }
    }

    public void reverseOrder()
    {
        synchronized (playlist)
        {
            System.out.println("reverse order");
            ListIterator<Song> l = playlist.listIterator(playlist.size());
            while(l.hasPrevious())
            {
                System.out.println(l.previous());
            }
        }
    }

    public void shuffle()
    {
        synchronized (playlist)
        {
            Collections.shuffle(playlist);
        }
    }

    public void reversePLaylist()
    {
        synchronized (playlist)
        {
            Collections.reverse(playlist);
        }
    }
}





