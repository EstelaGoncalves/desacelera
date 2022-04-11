package com.example.desacelera.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.desacelera1.R;

public class MainActivity extends AppCompatActivity {

   @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
   }
    public void imgb_dicassajudaprincipal(View v)
    {
        Intent ajuda = new Intent(this, ajuda.class);
        startActivity(ajuda);


    }

    public void imgb_dicaslivrosprincipal(View v)
    {
        Intent livros= new Intent(this, livros.class);
        startActivity(livros);
    }


    public void imgb_dicasplaylistprincipal(View v)
    {
        Intent playlist = new Intent(this, playlistActivity.class);
        startActivity(playlist);
    }

    public void imgb_dicasexerciciosprincipal(View v)
    {
        Intent exercicios = new Intent(this, exercicios.class);
        startActivity(exercicios);
    }


    public void imgb_acheoprofissionalprincipal(View v)
    {
        Intent profissional = new Intent(this, login.class);
        startActivity(profissional);
    }


    public void imgb_cadastrousuarioprofissionalprincipal(View v)
    {
        Intent cadastro
                = new Intent(this, escolha_usu_prof.class);
        startActivity(cadastro);
    }
}