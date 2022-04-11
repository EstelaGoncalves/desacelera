package com.example.desacelera.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.desacelera1.R;

public class ajuda extends AppCompatActivity {


    ImageButton Btn_voltardateladedicasdeajuda;
    ImageButton Img_sairajuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajuda);

        Btn_voltardateladedicasdeajuda = findViewById(R.id.btn_voltardateladedicasdeajuda);
        Img_sairajuda = findViewById(R.id.img_sairajuda);

           Img_sairajuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sair = new Intent(Intent.ACTION_MAIN);
                sair.addCategory(Intent.CATEGORY_HOME);
                sair.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(sair);
            }

        });

        Btn_voltardateladedicasdeajuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent voltarajuda = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(voltarajuda);
            }

        });

    }
    public void btn_voltardateladedicasdeajuda(View v)
    {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}