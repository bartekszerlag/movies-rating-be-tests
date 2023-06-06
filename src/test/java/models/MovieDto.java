package models;

public class MovieDto {

    private String title;
    private Double rating;
    private String votes;

    public MovieDto() {
    }

    public MovieDto(String title, Double rating, String votes) {
        this.title = title;
        this.rating = rating;
        this.votes = votes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }
}