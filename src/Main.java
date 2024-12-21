public class Main {
    public static void main(String[] args) {
        // example usage:
        StreamingService netflix = new StreamingService("notflix", 5.99f);
        StreamingService prime = new StreamingService("pwime", 4.99f);
        Film shawshankRedemption = new Film("The Shawshank Redemption", 1994, Genre.Drama, 4.759880f, 142);
        Film godfather = new Film("The Godfather", 1972, Genre.Drama, 3.296296f, 175);
        TVShow friends = new TVShow("Friends", Genre.Comedy, 3.95f);
        Season season1 = new Season(1, 22, 2010);
        Season season2 = new Season(2, 22, 2011);
        netflix.addMedia(shawshankRedemption);
        netflix.addMedia(godfather);
        prime.addMedia(friends, season1);
        netflix.addMedia(friends, season2);
        prime.listLibrary();
        netflix.listLibrary();
        godfather.getInformation();
        //feel free to add more examples and test the functionality as needed such as hosting constraints
    }
}
