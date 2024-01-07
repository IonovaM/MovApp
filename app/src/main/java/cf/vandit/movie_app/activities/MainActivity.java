package cf.vandit.movie_app.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import cf.vandit.movie_app.R;
import cf.vandit.movie_app.fragments.FavouritesFragment;
import cf.vandit.movie_app.fragments.MovieFragment;
import cf.vandit.movie_app.fragments.SearchFragment;
import cf.vandit.movie_app.fragments.SeriesFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    ContentFactory contentFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        toolbar = findViewById(R.id.toolbar_main);

        contentFactory = new ConcreteContentFactory(); // Инициализация конкретной фабрики

        // По умолчанию загружаем фрагмент с фильмами
        loadFragment(contentFactory.createMovieFragment(), "Фильмы");

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_movie:
                    loadFragment(contentFactory.createMovieFragment(), "Фильмы");
                    break;
                case R.id.nav_series:
                    loadFragment(contentFactory.createSeriesFragment(), "Сериалы");
                    break;
                case R.id.nav_search:
                    loadFragment(contentFactory.createSearchFragment(), "Поиск");
                    break;
                case R.id.nav_favourites:
                    loadFragment(contentFactory.createFavouritesFragment(), "Избранное");
                    break;
            }
            return true;
        });
    }

    private void loadFragment(Fragment fragment, String title) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
        toolbar.setTitle(title);
    }
}
