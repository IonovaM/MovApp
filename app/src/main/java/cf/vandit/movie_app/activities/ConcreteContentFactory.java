package cf.vandit.movie_app.activities;

import androidx.fragment.app.Fragment;

import cf.vandit.movie_app.fragments.FavouritesFragment;
import cf.vandit.movie_app.fragments.MovieFragment;
import cf.vandit.movie_app.fragments.SearchFragment;
import cf.vandit.movie_app.fragments.SeriesFragment;

public class ConcreteContentFactory implements ContentFactory {
    @Override
    public Fragment createMovieFragment() {
        return new MovieFragment();
    }

    @Override
    public Fragment createSeriesFragment() {
        return new SeriesFragment();
    }

    @Override
    public Fragment createSearchFragment() {
        return new SearchFragment();
    }

    @Override
    public Fragment createFavouritesFragment() {
        return new FavouritesFragment();
    }
}