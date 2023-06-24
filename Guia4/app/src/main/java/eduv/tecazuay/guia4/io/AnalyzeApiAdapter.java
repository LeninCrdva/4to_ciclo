package eduv.tecazuay.guia4.io;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnalyzeApiAdapter {

    private static ApiService ANALYZE_API;

    public static ApiService getApiService() {
        HttpLoggingInterceptor loggin = new HttpLoggingInterceptor();
        loggin.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpclient = new OkHttpClient.Builder();
        httpclient.addInterceptor(loggin);
        httpclient.addInterceptor(new Interceptor() {
            @NonNull
            @Override
            public okhttp3.Response intercept(@NonNull Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder requestBuilder = originalRequest.newBuilder()
                        .header("ApiKey", "b420c5b1-e1fc-4d82-81c0-0becd9e68e88"); // Reemplaza "tu_clave_de_api_aquí" con tu clave de API

                Request newRequest = requestBuilder.build();
                return chain.proceed(newRequest);
            }
        });

        if(ANALYZE_API == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.cloudmersive.com/nlp-v2/analytics/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpclient.build())
                    .build();
            ANALYZE_API = retrofit.create(ApiService.class);
        }

        return ANALYZE_API;
    }
}
