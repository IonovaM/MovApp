package cf.vandit.movie_app.activities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cf.vandit.movie_app.network.movie.MovieCastOfPerson;
import cf.vandit.movie_app.network.series.SeriesCastOfPerson;

// Пример реализации "Приспособленца" для кэширования информации о фильмах и сериалах для каждого актера/актрисы
public class CastInfoCash {
    private Map<Integer, List<MovieCastOfPerson>> moviesCache;
    private Map<Integer, List<SeriesCastOfPerson>> seriesCache;

    public CastInfoCash() {
        moviesCache = new HashMap<>();
        seriesCache = new HashMap<>();
    }

    public void addMoviesToCache(int personId, List<MovieCastOfPerson> movies) {
        moviesCache.put(personId, movies);
    }

    public List<MovieCastOfPerson> getMoviesFromCache(int personId) {
        return moviesCache.get(personId);
    }

    public void addSeriesToCache(int personId, List<SeriesCastOfPerson> series) {
        seriesCache.put(personId, series);
    }

    public List<SeriesCastOfPerson> getSeriesFromCache(int personId) {
        return seriesCache.get(personId);
    }
}
