package cf.vandit.movie_app.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import cf.vandit.movie_app.fragments.FavouriteMoviesFragment;
import cf.vandit.movie_app.fragments.FavouriteSeriesFragment;

// Класс FavouritesPagerAdapter, использующий фабричный метод для создания фрагментов
public class FavouritesPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private FragmentFactory[] fragmentFactories; // Массив фабрик для создания фрагментов

    public FavouritesPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;

        // Инициализация массива фабрик с конкретными фабриками для фрагментов
        fragmentFactories = new FragmentFactory[]{new MoviesFragmentFactory(), new SeriesFragmentFactory()};
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // Использование фабричного метода для создания фрагмента на основе позиции в массиве
        return fragmentFactories[position].createFragment(); // Создание фрагмента с помощью фабричного метода
    }

    @Override
    public int getCount() {
        return fragmentFactories.length; // Возвращает общее количество фрагментов в массиве
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        // Установка заголовков вкладок
        switch (position) {
            case 0:
                return "Фильмы";
            case 1:
                return "Сериалы";
        }
        return null;
    }
}
