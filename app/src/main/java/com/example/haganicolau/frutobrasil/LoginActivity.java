package com.example.haganicolau.frutobrasil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import entity.Message;
import entity.Token;
import interfaces.iRetrofitLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import interfaces.iRetrofitMessage;
import util.Database;


public class LoginActivity extends AppCompatActivity {

    EditText editEmail, editSenha;
    Button btnLogar;
    TextView editCadastro;
    private static final String TAG = "haganicolau";
    Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /*mensagem de ação*/
    public void message(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void logar(View view){
        editEmail = (EditText) findViewById(R.id.editEmail);
        String email = editEmail.getText().toString();

        editSenha = (EditText) findViewById(R.id.editSenha);
        String senha = editSenha.getText().toString();

        if(email == null || email.trim().equals("")){
            message("Email Obrigatório!");
        }

        if(senha == null || senha.trim().equals("")){
            message("Senha Obrigatória!");
        }

        iRetrofitLogin iLogin = iRetrofitLogin.retrofit
                .create(iRetrofitLogin.class);

        final Call<Token> call = iLogin.loginWithCredentials(email, senha);
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if (response.code() == 200) {
                    Token token = response.body();

                    if(token.getStatus().trim().equals("ok")){
                        db.saveToken(new Token(token.getToken()));
                        String teste = db.recoverToken();

                       finish();
                    }
                    else{
                        message("Email ou senha incorreto!");
                    }

                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {

            }
        });

    }

    public void createNewUser(View view){
        Intent it = new Intent(this, UserActivity.class);
        startActivity(it);
    }

}
