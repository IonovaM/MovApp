package cf.vandit.movie_app.adapters;
import androidx.fragment.app.Fragment;
import cf.vandit.movie_app.fragments.FavouriteMoviesFragment;

// Конкретная фабрика MoviesFragmentFactory, создающая фрагмент FavouriteMoviesFragment
public class MoviesFragmentFactory extends FragmentFactory {
    @Override
    public Fragment createFragment() {
        return new FavouriteMoviesFragment(); // Создание фрагмента FavouriteMoviesFragment
    }
}
