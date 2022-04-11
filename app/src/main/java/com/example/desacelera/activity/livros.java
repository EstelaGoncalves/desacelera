package com.example.desacelera.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.desacelera1.R;

public class livros extends AppCompatActivity {

    ImageButton Img_sairlivros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livros);

        Img_sairlivros = findViewById(R.id.img_sairlivros);

        Img_sairlivros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sair = new Intent(Intent.ACTION_MAIN);
                sair.addCategory(Intent.CATEGORY_HOME);
                sair.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(sair);
            }

        });


    }



    public void btn_voltardateladedicasdelivros(View v)
    {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}