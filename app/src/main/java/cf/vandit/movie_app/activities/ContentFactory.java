package cf.vandit.movie_app.activities;

import androidx.fragment.app.Fragment;

public interface ContentFactory {
    Fragment createMovieFragment();
    Fragment createSeriesFragment();
    Fragment createSearchFragment();
    Fragment createFavouritesFragment();
}