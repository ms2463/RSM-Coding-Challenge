/**
 * Class representing a season of a TV show, including the season number, year, and episode count.
 */
public class Season {
    private final int seasonNumber;  // The number of the season
    private final int year;          // The year the season was released
    private final int episodeCount;  // The number of episodes in the season
    private boolean hosted;          // Indicates whether the season is hosted by a streaming service

    /**
     * Constructor to initialize a Season object with season number, year, and episode count.
     * @param seasonNumber The number of the season.
     * @param year The year the season was released.
     * @param episodeCount The number of episodes in the season.
     */
    public Season(int seasonNumber, int year, int episodeCount) {
        this.seasonNumber = seasonNumber;
        this.year = year;
        this.episodeCount = episodeCount;
    }

    /**
     * Gets the season number.
     * @return The season number.
     */
    public int getSeasonNumber() {
        return seasonNumber;
    }

    /**
     * Gets the year the season was released.
     * @return The release year of the season.
     */
    public int getYear() {
        return year;
    }

    /**
     * Gets the number of episodes in the season.
     * @return The number of episodes in the season.
     */
    public int getEpisodeCount() {
        return episodeCount;
    }

    /**
     * Checks if the season is hosted by a streaming service.
     * @return True if the season is hosted, otherwise false.
     */
    public boolean isHosted() {
        return hosted;
    }

    /**
     * Sets the hosting status of the season.
     * @param hosted Boolean indicating if the season is hosted.
     */
    public void setHosted(boolean hosted) {
        this.hosted = hosted;
    }

    /**
     * Prints out detailed information about the season, including its season number, release year and episode count.
     */
    public void getInformation(){
        System.out.println("Season Number: " + getSeasonNumber()+"\nYear: " + getYear()+"\nEpisode Count: " + getEpisodeCount());
    }
}
