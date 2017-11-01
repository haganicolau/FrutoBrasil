package interfaces;

import entity.Message;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by root on 24/09/17.
 */

public interface iRetrofitMessage{
    @GET("/")
    Call<Message> getMessage();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://Apilp4-env.6sgg6raaea.sa-east-1.elasticbeanstalk.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
