package com.intro.android.presentation.injection;

import android.content.Context;

import com.intro.android.repository.adapter.NasaRoverRestAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import timber.log.Timber;

@Module
@Singleton
public class MainModule {

    private Context context;

    public MainModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    @Singleton
    NasaRoverRestAdapter nasaRoverRestAdapter(Retrofit retrofit) {
        return retrofit.create(NasaRoverRestAdapter.class);
    }

    @Provides
    @Singleton
    Picasso providePicasso() {
        return Picasso.with(context);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(MoshiConverterFactory moshiConverterFactory,
                             RxJavaCallAdapterFactory rxJavaCallAdapterFactory,
                             OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/mars-photos/api/v1/")
                .addConverterFactory(moshiConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    Moshi provideMoshi() {
        return new Moshi.Builder().build();
    }

    @Provides
    @Singleton
    MoshiConverterFactory provideMoshiConverterFactory(Moshi moshi) {
        return MoshiConverterFactory.create(moshi);
    }

    @Provides
    @Singleton
    RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor(HttpLoggingInterceptor.Logger logger) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(logger);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor.Logger provideHttpLogger() {
        return new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        };
    }
}
