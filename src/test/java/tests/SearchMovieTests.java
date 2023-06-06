package tests;

import models.MovieDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.hamcrest.Matchers.equalTo;

public class SearchMovieTests extends Base {

    @Test
    void shouldFindMovie() {
        //given
        String title = "Friends";

        //when
        MovieDto movie = given()
                .pathParam("title", title)
                .get("/rating/{title}")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().as(MovieDto.class);

        //then
        Assertions.assertThat(movie.getTitle()).isEqualTo(title);
        Assertions.assertThat(movie.getRating()).isNotNull();
        Assertions.assertThat(movie.getVotes()).isNotNull();
    }

    @Test
    void shouldNotFindMovie() {
        //given
        String title = "notexistingmovie";

        //then
        given()
                .pathParam("title", title)
                .get("/rating/{title}")
                .then()
                .assertThat()
                .statusCode(404)
                .body("message", equalTo(format("Not found movie: %s", title)));
    }
}