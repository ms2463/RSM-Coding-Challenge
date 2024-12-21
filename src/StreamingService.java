import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StreamingService {
    private final String name;
    private String price;
    private final List<MediaItem> library;
    public StreamingService(String name, float price) {
        this.name = name;
        setPrice(price);
        this.library=new ArrayList<>();
    }
    public String getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }

    private void setPrice(float price) {
        if(price<0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price= "£" + price;
    }
    public void addMedia(Film film) {
        if(film==null){
            throw new IllegalArgumentException("Film cannot be null");
        }
        else if(film.isHosted()){
            throw new IllegalArgumentException("Film already hosted by another streaming service");
        }
        else{
            for(MediaItem existingFilm: library){
                if(existingFilm instanceof Film &&
                   existingFilm.getName().equalsIgnoreCase(film.getName()) &&
                   ((Film)existingFilm).getYear() == film.getYear()){
                    throw new IllegalArgumentException("Film already exists in the library");
                }
            }
            library.add(film);
            film.setHosted(true);
        }
    }
    public void addMedia(TVShow tvShow) {
        if(tvShow==null){
            throw new IllegalArgumentException("TV show cannot be null");
        }
        else{
            for(MediaItem existingShow: library){
                if(existingShow instanceof TVShow && existingShow.getName().equalsIgnoreCase(tvShow.getName())){
                    throw new IllegalArgumentException("TV show already exists in the library");
                }
            }
        }
        library.add(tvShow);
    }
    public void addMedia(TVShow tvShow, Season season) {
        if(tvShow==null){
            throw new IllegalArgumentException("TV show cannot be null");
        }
        else if(season==null){
            throw new IllegalArgumentException("Season cannot be null");
        }
        else if(season.isHosted()){
            throw new IllegalArgumentException("Season already hosted by another streaming service");
        }
        if(!library.contains(tvShow)){
            library.add(tvShow);
        }
        if(!tvShow.getHostedSeasons(getName()).contains(season)){
            tvShow.addSeason(getName(),season);
            season.setHosted(true);
        }
    }

    public void removeMedia(MediaItem media) {
        if(media==null){
            throw new IllegalArgumentException("Media cannot be null");
        }
        else if(!library.contains(media)){
            throw new IllegalArgumentException("Media not found in the library");
        }
        else{
            library.remove(media);
            if(media instanceof Film){
                ((Film) media).setHosted(false);
            }
            else if(media instanceof TVShow tvShow){
                for(Season season: tvShow.getHostedSeasons(getName())){
                    season.setHosted(false);
                }
                library.remove(media);
            }
        }
    }
    public void removeMedia(TVShow tvShow, Season season){
        tvShow.removeSeason(this, season);
        season.setHosted(false);

    }
    public void listLibrary(){
        System.out.println("\nStreaming service: "+name+" | Price: "+price+"\n\nLibrary:");
        for(MediaItem media: library){
            if(media instanceof Film){
                System.out.println(((Film) media).getName()+" | "+((Film) media).getYear());
            }
            else if(media instanceof TVShow){
                System.out.println(((TVShow) media).getName()+":");
                for(Season season: ((TVShow) media).getHostedSeasons(getName())){
                    System.out.println("Season "+season.getSeasonNumber());
                }
            }
        }
        //rateMedia();
    }
    public void rateMedia(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the name of the film/show to rate:");
        String filmName = scanner.nextLine();
        MediaItem selectedFilm = null;
        for(MediaItem media: this.library){
            if(media.getName().equalsIgnoreCase(filmName)){
                selectedFilm=media;
                break;
            }
        }
        if(selectedFilm==null){
            System.out.println("Film not found in the library");
        }
        else{
            System.out.println("Enter your rating (0-5):");
            float rating = scanner.nextFloat();
            selectedFilm.setRating(rating);
            System.out.println("Rating submitted successfully");
        }
    }
}
