/**
 * Film class represents a film that can be added to a streaming service's library.
 * Inherits from the MediaItem class and includes additional details like year, runtime, and hosting status.
 */
public class Film extends MediaItem {
    private final int year;  // The year the film was released
    private final float runtime;  // The runtime of the film in minutes
    private Boolean hosted;  // Indicates whether the film is hosted by a streaming service

    /**
     * Constructor to initialize a Film object with its name, year of release, genre, rating, and runtime.
     * @param name The name of the film.
     * @param year The year the film was released.
     * @param genre The genre of the film.
     * @param rating The rating of the film (0 to 5 scale).
     * @param runtime The runtime of the film in minutes.
     */
    public Film(String name, int year, Genre genre, float rating, float runtime) {
        super(name, genre, rating);  // Call the constructor of the superclass MediaItem
        this.year = year;  // Set the year of the film
        this.runtime = runtime;  // Set the runtime of the film
        this.hosted = false;  // Initially, the film is not hosted by any service
    }

    /**
     * Sets the hosting state of the film (whether it's hosted by a streaming service).
     * @param state Boolean indicating if the film is hosted or not.
     */
    void setHosted(Boolean state) {
        hosted = state;  // Set the hosting state
    }

    /**
     * Checks if the film is hosted by a streaming service.
     * @return True if the film is hosted, otherwise false.
     */
    public boolean isHosted() {
        return hosted;  // Return the current hosting state
    }

    /**
     * Gets the year the film was released.
     * @return The release year of the film.
     */
    public int getYear() {
        return year;  // Return the year of release
    }

    /**
     * Gets the runtime of the film.
     * @return The runtime of the film in minutes.
     */
    public float getRuntime() {
        return runtime;  // Return the runtime in minutes
    }

    /**
     * Prints out detailed information about the film, including its title, release year, genre, rating, and runtime.
     */
    public void getInformation() {
        System.out.println("Film title: " + getName() + "\nYear of release: " + getYear() +
                "\nGenre: " + getGenre() + "\nRating: " + getRating() +
                "\nRuntime: " + getRuntime() + " minutes");
    }
}
