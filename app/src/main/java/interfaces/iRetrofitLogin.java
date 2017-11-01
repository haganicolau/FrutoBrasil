package interfaces;

import entity.Token;
import entity.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by haganicolau on 15/10/17.
 */

public interface iRetrofitLogin {
    @FormUrlEncoded
    @POST("/login")
    Call<Token> loginWithCredentials(@Field("email") String email, @Field("password") String password);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://Apilp4-env.6sgg6raaea.sa-east-1.elasticbeanstalk.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
