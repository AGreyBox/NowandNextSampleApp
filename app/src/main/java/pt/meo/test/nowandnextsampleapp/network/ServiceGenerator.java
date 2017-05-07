package pt.meo.test.nowandnextsampleapp.network;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import pt.meo.test.nowandnextsampleapp.BuildConfig;
import pt.meo.test.nowandnextsampleapp.NowAndNextSampleApplication;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Service generator class to build the Retrofit services
 * Created by dplopez on 07-05-2017.
 */

public class ServiceGenerator {
    private static final int DISK_CACHE_SIZE = 5 * 1024 * 1024; // 5MB

    private static Retrofit.Builder retrofitBuilder
            = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create());

    private static OkHttpClient defaultOkHttpClient
            = new OkHttpClient.Builder()
            .cache(getCache())
            .build();
    private ServiceGenerator() {
    }

    public static <S> S createService(Class<S> serviceClass, String baseUrl) {
        OkHttpClient.Builder okHttpClientBuilder = defaultOkHttpClient.newBuilder();

        OkHttpClient modifiedOkHttpClient = okHttpClientBuilder
                .addInterceptor(getHttpLoggingInterceptor())
                .build();

        retrofitBuilder.client(modifiedOkHttpClient);
        retrofitBuilder.baseUrl(baseUrl);

        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }

    private static Cache getCache() {

        Cache cache = null;
        // Install an HTTP cache in the application cache directory.
        try {
            File cacheDir = new File(NowAndNextSampleApplication.getCacheDirectory(), "http");
            cache = new Cache(cacheDir, DISK_CACHE_SIZE);
        } catch (Exception e) {
            Timber.e(e, "Unable to install disk cache.");
        }
        return cache;
    }

    private static HttpLoggingInterceptor getHttpLoggingInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return httpLoggingInterceptor;
    }
}
