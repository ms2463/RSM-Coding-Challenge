import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<String, StreamingService> streamingServices = new HashMap<>();

    public static void main(String[] args) {
        StreamingService notflix = new StreamingService("notflix", 5.99f);
        StreamingService hulu = new StreamingService("hulu", 4.99f);
        Film newfilm = new Film("The Shawshank Redemption", 1994, Genre.Drama, 4.759880f, 142);
        notflix.addMedia(newfilm);
        Film newfilm2 = new Film("Pulp Fiction", 1994, Genre.Action, 4.874219f, 154);
        notflix.addMedia(newfilm2);
        TVShow newShow = new TVShow("Friends", Genre.Comedy, 3.7f);
        Season season1 = new Season(1, 22, 2010);
        notflix.addMedia(newShow, season1);
        Season season2 = new Season(2, 20, 2011);
        hulu.addMedia(newShow, season2);
        Season season3 = new Season(3, 22, 2012);
        hulu.addMedia(newShow, season3);
        Season season4 = new Season(4, 20, 2013);
        hulu.addMedia(newShow, season4);
        notflix.listLibrary();
        hulu.listLibrary();
        hulu.removeMedia(newShow, season2);
        notflix.removeMedia(newfilm2);
        hulu.addMedia(newfilm2);
        notflix.addMedia(newShow, season2);
        hulu.listLibrary();
        notflix.listLibrary();
        StreamingService hbo = new StreamingService("HBO", 4.99f);
        hbo.addMedia(newShow);
        hbo.listLibrary();
        hbo.removeMedia(newShow);
        hbo.listLibrary();

    }
}
