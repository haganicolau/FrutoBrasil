package com.example.haganicolau.frutobrasil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import entity.Message;
import interfaces.iRetrofitUser;

import entity.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    EditText editEmail, editLogin, editPassword, editConfirmPassword, editPhone;
    Button bntCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        editPhone = (EditText) findViewById(R.id.editPhone);

        setContentView(R.layout.activity_user);

    }

    public void createNewUser(View view){
        User user = new User();
        editEmail = (EditText) findViewById(R.id.editEmail);
        user.setEmail(editEmail.getText().toString());

        editPassword = (EditText) findViewById(R.id.editPassword);
        user.setPassword(editPassword.getText().toString());

        editLogin = (EditText) findViewById(R.id.editLogin);
        user.setLogin(editLogin.getText().toString());

        editConfirmPassword = (EditText) findViewById(R.id.editConfirmPassword);
        user.setPassword_confirm(editConfirmPassword.getText().toString());

        user.setPhone(editPhone.getText().toString());

        iRetrofitUser iUser = iRetrofitUser.retrofit.create(iRetrofitUser.class);
        final Call<Message> call = iUser.postUser(user);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                if(response.code() == 200){
                    Message msg = response.body();
                    if(msg.getStatus().equals("ok")){
                        message(msg.getMessage());
                        finish();
                    } else{
                        message(msg.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {

            }
        });


    }


    /*mensagem de ação*/
    public void message(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
