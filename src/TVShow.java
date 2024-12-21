import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TVShow extends MediaItem {
    private final HashMap<Season, String> hostedSeasons;
    public TVShow(String name, Genre genre, float rating) {
        super(name,genre,rating);
        this.hostedSeasons = new HashMap<>();
    }
    public void addSeason(String hostName,Season season){
        if(season==null || season.getSeasonNumber() <= 0 || season.getEpisodeCount() <= 0)
            throw new IllegalArgumentException("Invalid season data.");
        hostedSeasons.put(season, hostName);
    }
    public List<Season> getHostedSeasons(String hostName) {
        List<Season> returnedList = new ArrayList<>();
        for(Season season : hostedSeasons.keySet()){
            if(hostedSeasons.get(season).equalsIgnoreCase(hostName)){
                returnedList.add(season);
            }
        }
        return returnedList;
    }

    public void removeSeason(StreamingService streamingService,Season season) {
        if(season==null){
            throw new IllegalArgumentException("Season cannot be null");
        }
        else if(!getHostedSeasons(streamingService.getName()).contains(season)){
            throw new IllegalArgumentException("Season not found in the library");
        }
        else{
            hostedSeasons.remove(season);
        }
    }
}
