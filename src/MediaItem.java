public abstract class MediaItem {
    private final String name;
    private final Genre genre;
    private float rating;

    public MediaItem(String name, Genre genre, float rating){
        this.name = name;
        this.genre = genre;
        setRating(rating);
    }
    public String getName(){
        return name;
    }
    public Genre getGenre() {
        return genre;
    }
    public float getRating(){
        return rating;
    }
    void setRating(float rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = (float)(Math.round(rating*100)/100.0);
        } else {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
    }
}