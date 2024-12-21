public class Film extends MediaItem {
    private final int year;
    private final float runtime;
    private Boolean hosted;
    public Film(String name, int year, Genre genre, float rating, float runtime){
        super(name, genre, rating);
        this.year = year;
        this.runtime = runtime;
        this.hosted = false;
    }
    void setHosted(Boolean state){
        hosted=state;
    }
    public boolean isHosted(){
        return hosted;
    }
    public int getYear(){
        return year;
    }
    public float getRuntime(){
        return runtime;
    }
    public void getInformation(){
        System.out.println("Film title: "+getName()+"\nYear of release: "+ getYear() +"\nGenre: "+getGenre()+"\nRating: "+getRating()+"\nRuntime: "+runtime+" minutes");
    }
}
