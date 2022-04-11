package com.example.desacelera.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.desacelera1.R;



public class escolha_usu_prof extends AppCompatActivity {

    ImageButton Imgv_sairescolhausuarioouprofissional;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolhausuarioouprofissional);

        Imgv_sairescolhausuarioouprofissional=findViewById(R.id.imgv_sairescolhausuarioouprofissional);

        Imgv_sairescolhausuarioouprofissional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sair = new Intent(Intent.ACTION_MAIN);
                sair.addCategory(Intent.CATEGORY_HOME);
                sair.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(sair);
            }

        });

    }

    public void btn_cadastrodeusuarioescolha(View v)
    {
        Intent cadastro = new Intent(this, cadastro_usuario.class);
        startActivity(cadastro);
    }

    public void btn_cadastroprofissionalescolha(View v)
    {
        Intent profissional = new Intent(this, cadastro_profissional.class);
        startActivity(profissional);
    }


    public void btn_voltardateladecadastro(View v)
    {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}