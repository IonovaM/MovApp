package cf.vandit.movie_app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import cf.vandit.movie_app.database.movies.FavMovie;

public class FavMovieTest {

    private FavMovie favMovie;

    // Создание экземпляра FavMovie перед каждым тестом
    @Before
    public void setUp() {
        favMovie = new FavMovie(1, 12345, "Test Movie", "poster_path");
    }

    // Тест проверяет, возвращает ли метод getId() правильный ID
    @Test
    public void getId_returnsCorrectId() {
        assertEquals(1, favMovie.getId());
    }

    // Тест проверяет, устанавливает ли метод setId() ID правильно
    @Test
    public void setId_setsIdCorrectly() {
        favMovie.setId(2);
        assertEquals(2, favMovie.getId());
    }

    // Тест проверяет, возвращает ли метод getMovie_id() правильный идентификатор фильма
    @Test
    public void getMovie_id_returnsCorrectMovieId() {
        assertEquals(Integer.valueOf(12345), favMovie.getMovie_id());
    }

    // Тест проверяет, устанавливает ли метод setMovie_id() идентификатор фильма правильно
    @Test
    public void setMovie_id_setsMovieIdCorrectly() {
        favMovie.setMovie_id(54321);
        assertEquals(Integer.valueOf(54321), favMovie.getMovie_id());
    }

    // Тест проверяет, возвращает ли метод getPoster_path() правильный путь к постеру
    @Test
    public void getPoster_path_returnsCorrectPosterPath() {
        assertEquals("poster_path", favMovie.getPoster_path());
    }

    // Тест проверяет, устанавливает ли метод setPoster_path() путь к постеру правильно
    @Test
    public void setPoster_path_setsPosterPathCorrectly() {
        favMovie.setPoster_path("new_poster_path");
        assertEquals("new_poster_path", favMovie.getPoster_path());
    }

    // Тест проверяет, возвращает ли метод getName() правильное название фильма
    @Test
    public void getName_returnsCorrectName() {
        assertEquals("Test Movie", favMovie.getName());
    }

    // Тест проверяет, устанавливает ли метод setName() название фильма правильно
    @Test
    public void setName_setsNameCorrectly() {
        favMovie.setName("Updated Test Movie");
        assertEquals("Updated Test Movie", favMovie.getName());
    }
}
