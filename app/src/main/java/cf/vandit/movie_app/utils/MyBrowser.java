package cf.vandit.movie_app.utils;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;
public class MyBrowser extends WebViewClient {

    // Метод, который перехватывает URL-адреса, загружаемые в WebView и открывает их внутри WebView
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        // Загружаем URL в WebView
        view.loadUrl(url);
        // Возвращаем true, чтобы указать, что мы обработали загрузку URL внутри WebView
        return true;
    }

    // Хранилище URL-адресов и признаков, являются ли они рекламными
    private Map<String, Boolean> loadedUrls = new HashMap<>();

    // Метод, который перехватывает запросы к URL-адресам и позволяет блокировать рекламные ресурсы
    @Nullable
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        boolean ad;
        // Проверяем, есть ли URL уже в нашем хранилище
        if (!loadedUrls.containsKey(url)) {
            // Если URL не найден, проверяем, является ли он рекламным с помощью AdBlocker
            ad = AdBlocker.isAd(url);
            // Запоминаем результат проверки в хранилище
            loadedUrls.put(url, ad);
        } else {
            // Если URL найден в хранилище, используем сохраненное значение
            ad = loadedUrls.get(url);
        }
        // Если URL является рекламным, возвращаем пустой ресурс для блокировки, в противном случае загружаем ресурс
        return ad ? AdBlocker.createEmptyResource() :
                super.shouldInterceptRequest(view, url);
    }
}

