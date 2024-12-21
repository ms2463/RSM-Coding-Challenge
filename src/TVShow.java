import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class representing a TV show, which can have multiple hosted seasons on different streaming services.
 * Allows adding, retrieving, and removing seasons from the show.
 */
public class TVShow extends MediaItem {
    private final HashMap<Season, String> hostedSeasons;  // A map to track which seasons are hosted by which service

    /**
     * Constructor to initialize a TV show with name, genre, and rating.
     * @param name The name of the TV show.
     * @param genre The genre of the TV show.
     * @param rating The rating of the TV show.
     */
    public TVShow(String name, Genre genre, float rating) {
        super(name, genre, rating);
        this.hostedSeasons = new HashMap<>();
    }

    /**
     * Adds a season to the TV show, associating it with a specific streaming service.
     * @param hostName The name of the streaming service hosting the season.
     * @param season The season to add.
     * @throws IllegalArgumentException If the season or its details are invalid.
     */
    public void addSeason(String hostName, Season season) {
        if (season == null || season.getSeasonNumber() <= 0 || season.getEpisodeCount() <= 0) {
            throw new IllegalArgumentException("Invalid season data.");
        }
        hostedSeasons.put(season, hostName);
    }

    /**
     * Gets a list of seasons hosted by a specific streaming service.
     * @param hostName The name of the streaming service.
     * @return A list of seasons hosted by the specified service.
     */
    public List<Season> getHostedSeasons(String hostName) {
        List<Season> returnedList = new ArrayList<>();
        for (Season season : hostedSeasons.keySet()) {
            if (hostedSeasons.get(season).equalsIgnoreCase(hostName)) {
                returnedList.add(season);
            }
        }
        return returnedList;
    }

    /**
     * Removes a season from a specific streaming service's hosting.
     * @param streamingService The streaming service from which the season should be removed.
     * @param season The season to remove.
     * @throws IllegalArgumentException If the season is not found in the streaming service's library.
     */
    public void removeSeason(StreamingService streamingService, Season season) {
        if (season == null) {
            throw new IllegalArgumentException("Season cannot be null");
        } else if (!getHostedSeasons(streamingService.getName()).contains(season)) {
            throw new IllegalArgumentException("Season not found in the library");
        } else {
            hostedSeasons.remove(season);
        }
    }

    /**
     * Prints out detailed information about the TV show, including its title, genre, rating, and amount of seasons hosted.
     */
    public void listInformation(){
        System.out.println("TV Show Name: " + getName()+"\nGenre: " + getGenre()+"\nRating: " + getRating()+"\n Seasons Hosted: "+hostedSeasons.size());
        }
}
