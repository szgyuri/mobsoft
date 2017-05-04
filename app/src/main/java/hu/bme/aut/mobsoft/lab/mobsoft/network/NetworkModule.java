package hu.bme.aut.mobsoft.lab.mobsoft.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.mobsoft.lab.mobsoft.network.element.ElementApi;
import hu.bme.aut.mobsoft.lab.mobsoft.util.GsonHelper;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Szabo Gyorgy on 2017. 04. 21..
 */

@Module
public class NetworkModule {
    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient().newBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(NetworkConfig.ENDPOINT_ADDRESS)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson()))
                .build();
    }

    @Provides
    @Singleton
    public ElementApi provideATodoApi(Retrofit retrofit) {
        return retrofit.create(ElementApi.class);
    }

}
