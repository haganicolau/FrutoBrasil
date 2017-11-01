package interfaces;

import entity.Message;
import entity.User;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by haganicolau on 24/10/17.
 */

public interface iRetrofitUser {

    @POST("/user")
    Call<Message> postUser(@Body User user);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://Apilp4-env.6sgg6raaea.sa-east-1.elasticbeanstalk.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
