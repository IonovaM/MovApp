package cf.vandit.movie_app;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

import cf.vandit.movie_app.network.movie.MovieBrief;

public class MovieBriefTest {

    @Test
    public void testMovieTitle() {
        String expectedTitle = "Movie Title";
        MovieBrief movie = new MovieBrief(null, null, null, null,
                expectedTitle, null, null, null,
                null, null, null, null, null, null);

        String actualTitle = movie.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    // Напишите другие тесты для других методов по аналогии с приведенным выше примером
}
