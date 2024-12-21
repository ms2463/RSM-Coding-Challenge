/**
 * A class to represent a streaming service platform, where users can manage films and TV shows.
 * Allows users to add, remove, and rate media items.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StreamingService {
    private final String name;
    private String price;
    private final List<MediaItem> library;

    /**
     * Constructor to initialize a streaming service with a name and price.
     * @param name The name of the streaming service.
     * @param price The price of the streaming service.
     */
    public StreamingService(String name, float price) {
        this.name = name;
        setPrice(price);  // Set price, ensuring it's not negative
        this.library = new ArrayList<>();  // Initialize the media library as an empty list
    }

    /**
     * Gets the price of the streaming service.
     * @return The price of the streaming service.
     */
    public String getPrice() {
        return price;
    }

    /**
     * Gets the name of the streaming service.
     * @return The name of the streaming service.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the price of the streaming service, ensuring that the price is not negative.
     * @param price The price to set.
     */
    private void setPrice(float price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = "£" + price;  // Format the price with a currency symbol
    }

    /**
     * Adds a film to the media library.
     * Ensures the film is not null, doesn't already exist, and is not hosted by another service.
     * @param film The Film object to add.
     */
    public void addMedia(Film film) {
        if (film == null) {
            throw new IllegalArgumentException("Film cannot be null");
        } else if (film.isHosted()) {
            throw new IllegalArgumentException("Film already hosted by another streaming service");
        } else {
            // Check if the film already exists in the library
            for (MediaItem existingFilm : library) {
                if (existingFilm instanceof Film &&
                        existingFilm.getName().equalsIgnoreCase(film.getName()) &&
                        ((Film) existingFilm).getYear() == film.getYear()) {
                    throw new IllegalArgumentException("Film already exists in the library");
                }
            }
            // Add the film to the library and mark it as hosted
            library.add(film);
            film.setHosted(true);
        }
    }

    /**
     * Adds a TV show to the media library.
     * Ensures the TV show is not null and doesn't already exist in the library.
     * @param tvShow The TVShow object to add.
     */
    public void addMedia(TVShow tvShow) {
        if (tvShow == null) {
            throw new IllegalArgumentException("TV show cannot be null");
        } else {
            // Check if the TV show already exists in the library
            for (MediaItem existingShow : library) {
                if (existingShow instanceof TVShow && existingShow.getName().equalsIgnoreCase(tvShow.getName())) {
                    throw new IllegalArgumentException("TV show already exists in the library");
                }
            }
        }
        // Add the TV show to the library
        library.add(tvShow);
    }

    /**
     * Adds a season to a TV show in the library.
     * Ensures the TV show, season are not null, and the season is not already hosted by another service.
     * @param tvShow The TV show to which the season is added.
     * @param season The Season object to add.
     */
    public void addMedia(TVShow tvShow, Season season) {
        if (tvShow == null) {
            throw new IllegalArgumentException("TV show cannot be null");
        } else if (season == null) {
            throw new IllegalArgumentException("Season cannot be null");
        } else if (season.isHosted()) {
            throw new IllegalArgumentException("Season already hosted by another streaming service");
        }
        // Add the TV show if it isn't already in the library
        if (!library.contains(tvShow)) {
            library.add(tvShow);
        }
        // Add the season to the TV show if it isn't already hosted by a streaming service
        if (!tvShow.getHostedSeasons(getName()).contains(season)) {
            tvShow.addSeason(getName(), season);
            season.setHosted(true);
        }
    }

    /**
     * Removes a media item (film or TV show) from the library.
     * Ensures the media item exists in the library before removing it.
     * @param media The MediaItem (either Film or TVShow) to remove.
     */
    public void removeMedia(MediaItem media) {
        if (media == null) {
            throw new IllegalArgumentException("Media cannot be null");
        } else if (!library.contains(media)) {
            throw new IllegalArgumentException("Media not found in the library");
        } else {
            // Remove the media item and mark its hosted status as false
            library.remove(media);
            if (media instanceof Film) {
                ((Film) media).setHosted(false);
            } else if (media instanceof TVShow tvShow) {
                for (Season season : tvShow.getHostedSeasons(getName())) {
                    season.setHosted(false);
                }
                library.remove(media);  // Remove the TV show as well
            }
        }
    }

    /**
     * Removes a specific season from a TV show.
     * Ensures the season is part of the TV show and marks it as not hosted.
     * @param tvShow The TV show from which the season will be removed.
     * @param season The Season object to remove.
     */
    public void removeMedia(TVShow tvShow, Season season) {
        tvShow.removeSeason(this, season);  // Remove the season from the TV show
        season.setHosted(false);  // Mark the season as not hosted
    }

    /**
     * Lists all the media items in the streaming service's library, including films and TV shows.
     * Displays the title of films and TV shows, and the season number for TV shows.
     */
    public void listLibrary() {
        System.out.println("\nStreaming service: " + getName() + " | Price: " + getPrice() + "\n\nLibrary:");
        for (MediaItem media : library) {
            if (media instanceof Film) {
                // Print details for each film in the library
                System.out.println(((Film) media).getName() + " | " + ((Film) media).getYear());
            } else if (media instanceof TVShow) {
                // Print the TV show's name and list its seasons
                System.out.println(((TVShow) media).getName() + ":");
                for (Season season : ((TVShow) media).getHostedSeasons(getName())) {
                    System.out.println("Season " + season.getSeasonNumber());
                }
            }
        }
        rateMedia();  // Allow the user to rate a media item after listing
    }

    /**
     * Prompts the user to rate a film or TV show in the library.
     * The user is asked to input the media name and the rating value (0-5).
     */
    public void rateMedia() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the name of the film/show to rate:");
        String filmName = scanner.nextLine();  // Get the media name from user input
        MediaItem selectedFilm = null;
        for (MediaItem media : this.library) {
            if (media.getName().equalsIgnoreCase(filmName)) {
                selectedFilm = media;  // Find the media in the library
                break;
            }
        }
        if (selectedFilm == null) {
            System.out.println("Film not found in the library");  // Show error if not found
        } else {
            System.out.println("Enter your rating (0-5):");
            float rating = scanner.nextFloat();  // Get the rating value from the user
            selectedFilm.setRating(rating);  // Set the rating for the selected media
            System.out.println("Rating submitted successfully");  // Confirm the rating submission
        }
    }
}
