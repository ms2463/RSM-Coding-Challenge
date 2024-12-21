/**
 * Abstract class representing a media item (e.g. film, TV show).
 * Contains common attributes such as name, genre, and rating.
 */
public abstract class MediaItem {
    private final String name;  // The name of the media item
    private final Genre genre;  // The genre of the media item
    private float rating;       // The rating of the media item

    /**
     * Constructor to initialize a MediaItem object with name, genre, and rating.
     * @param name The name of the media item.
     * @param genre The genre of the media item.
     * @param rating The rating of the media item (0 to 5 scale).
     */
    public MediaItem(String name, Genre genre, float rating){
        this.name = name;
        this.genre = genre;
        setRating(rating);  // Set the rating while ensuring it's valid
    }

    /**
     * Gets the name of the media item.
     * @return The name of the media item.
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the genre of the media item.
     * @return The genre of the media item.
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Gets the rating of the media item.
     * @return The rating of the media item.
     */
    public float getRating(){
        return rating;
    }

    /**
     * Sets the rating for the media item, ensuring it's between 0 and 5.
     * @param rating The rating to set.
     * @throws IllegalArgumentException If the rating is not between 0 and 5.
     */
    void setRating(float rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = (float)(Math.round(rating*100)/100.0);  // Round to 2 decimal places
        } else {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
    }
}
