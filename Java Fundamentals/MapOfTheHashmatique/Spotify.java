import java.util.HashMap;
import java.util.Set;

public class Spotify {
    public static void main(String[] args) {
        // 1- Create a trackList of type HashMap
        HashMap<String, String> trackList = new HashMap<String, String>();

        // 2-Add in at least 4 songs that are stored by title

        trackList.put("Havana", "Havana, ooh na-na");
        trackList.put("Fukumean", "Young Gunna Wunna back, callin' me splurge");
        trackList.put("Another love", "I wanna take you somewhere so you know I care");
        trackList.put("Mockingbird ", "But I promise momma's gonna be alright");

        // 3- Pull out one of the songs by its track title

        String havanaLyrics = trackList.get("Havana");
        System.out.println("havana lyrics: " + havanaLyrics);

        // 4- Print out all the track names and lyrics in the format Track: Lyrics

        Set<String> keys = trackList.keySet();
        for (String key : keys) {
            System.out.println("Title: " + key);
            System.out.println("Lyrics: " + trackList.get(key));
        }

    }
}
