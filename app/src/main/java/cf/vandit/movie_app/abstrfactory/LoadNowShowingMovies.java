package cf.vandit.movie_app.abstrfactory;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cf.vandit.movie_app.adapters.MovieBriefSmallAdapter;
import cf.vandit.movie_app.adapters.MovieCarouselAdapter;
import cf.vandit.movie_app.adapters.MoviesNestedRecViewAdapter;
import cf.vandit.movie_app.network.movie.GenreMoviesResponse;
import cf.vandit.movie_app.network.movie.MovieBrief;
import cf.vandit.movie_app.network.movie.NowShowingMoviesResponse;
import cf.vandit.movie_app.network.movie.PopularMoviesResponse;
import cf.vandit.movie_app.network.movie.TopRatedMoviesResponse;
import cf.vandit.movie_app.request.ApiClient;
import cf.vandit.movie_app.request.ApiInterface;
import cf.vandit.movie_app.utils.Constants;
import cf.vandit.movie_app.utils.NestedRecViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadNowShowingMovies {

}
