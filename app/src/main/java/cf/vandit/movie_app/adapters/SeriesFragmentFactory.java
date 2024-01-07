package cf.vandit.movie_app.adapters;
import androidx.fragment.app.Fragment;
import cf.vandit.movie_app.fragments.FavouriteSeriesFragment;

// Конкретная фабрика SeriesFragmentFactory, создающая фрагмент FavouriteSeriesFragment
public class SeriesFragmentFactory extends FragmentFactory {
    @Override
    public Fragment createFragment() {
        return new FavouriteSeriesFragment(); // Создание фрагмента FavouriteSeriesFragment
    }
}
