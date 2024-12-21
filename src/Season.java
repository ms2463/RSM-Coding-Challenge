public class Season {
    private final int seasonNumber;
    private final int year;
    private final int episodeCount;
    private boolean hosted;
    public Season(int seasonNumber, int year, int episodeCount){
        this.seasonNumber = seasonNumber;
        this.year = year;
        this.episodeCount = episodeCount;
    }
    public int getSeasonNumber() {
        return seasonNumber;
    }
    public int getYear() {
        return year;
    }
    public int getEpisodeCount() {
        return episodeCount;
    }
    public boolean isHosted() {
        return hosted;
    }
    public void setHosted(boolean hosted) {
        this.hosted = hosted;
    }
}
