package cf.vandit.movie_app.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import cf.vandit.movie_app.R;
import cf.vandit.movie_app.utils.AdBlocker;
import cf.vandit.movie_app.utils.Constants;
import cf.vandit.movie_app.utils.MyBrowser;

public class MovieStreamActivity extends AppCompatActivity {

    private WebView webView; // Объект WebView для отображения веб-содержимого
    private ImageButton backButton; // Кнопка "назад"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AdBlocker.init(this); // Инициализация блокировщика рекламы

        // Настройка отображения приложения: скрытие системных элементов и установка флага полноэкранного режима
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); // Добавление флага для отображения в полноэкранном режиме

        setContentView(R.layout.activity_movie_stream); // Установка макета для этой активности

        backButton = findViewById(R.id.backButton); // Нахождение кнопки "назад" в макете

        webView = findViewById(R.id.WebView); // Нахождение WebView в макете
        webView.setWebViewClient(new MyBrowser()); // Установка клиента WebView для обработки веб-страниц
        webView.setWebChromeClient(new ChromeClient()); // Установка клиента для работы с элементами Chrome

        webView.getSettings().setJavaScriptEnabled(true); // Включение поддержки JavaScript

        // Получение movieId из Intent и загрузка URL в WebView
        Intent receivedIntent = getIntent();
        String movieId = receivedIntent.getStringExtra("movie_id");
        webView.loadUrl(Constants.MOVIE_STREAM_URL + movieId);

        // Обработчик нажатия кнопки "назад"
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    // Класс для работы с элементами Chrome в WebView
    private class ChromeClient extends WebChromeClient {
        private View mCustomView;
        private WebChromeClient.CustomViewCallback mCustomViewCallback;
        protected FrameLayout mFullscreenContainer;
        private int mOriginalOrientation;
        private int mOriginalSystemUiVisibility;

        ChromeClient() {}

        // Получение изображения по умолчанию для видео
        public Bitmap getDefaultVideoPoster() {
            if (mCustomView == null) {
                return null;
            }
            return BitmapFactory.decodeResource(getApplicationContext().getResources(), 2130837573);
        }

        // Скрытие пользовательского представления
        public void onHideCustomView() {
            ((FrameLayout)getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }

        // Отображение пользовательского представления
        public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {
            if (this.mCustomView != null) {
                onHideCustomView();
                return;
            }
            this.mCustomView = paramView;
            this.mOriginalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            this.mOriginalOrientation = getRequestedOrientation();
            this.mCustomViewCallback = paramCustomViewCallback;
            ((FrameLayout)getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
            getWindow().getDecorView().setSystemUiVisibility(3846 | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }

    // Обработка нажатия системной кнопки "назад"
    @Override
    public void onBackPressed() {
        if(webView!=null && webView.canGoBack()) {
            webView.goBack(); // Переход на предыдущую страницу WebView, если возможно
        } else {
            super.onBackPressed(); // В противном случае, обработка нажатия системной кнопки "назад" по умолчанию
        }
    }
}
