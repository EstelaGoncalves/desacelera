package com.example.desacelera.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.desacelera.database.BancoSQLite;
import com.example.desacelera1.R;
import com.exemple.desacelera.model.Profissional;


public class acheoprofissional<btn_voltardatelaacheoprofissional> extends AppCompatActivity {

    ImageButton Btn_voltardatelaacheoprofissional;
    ListView Lst_view;
    Button Btn_preenchaafichaanamneseacheoprofissional;
    ImageButton Img_sairacheprofissional;
    String id_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acheoprofissional);


        Btn_voltardatelaacheoprofissional = findViewById(R.id.btn_voltardatelaacheoprofissional);

        Lst_view = findViewById(R.id.lstview);

        Btn_preenchaafichaanamneseacheoprofissional = findViewById(R.id.btn_preenchaafichaanamneseacheoprofissional);

        Img_sairacheprofissional = findViewById(R.id.img_sairacheprofissional);

        Img_sairacheprofissional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sair = new Intent(Intent.ACTION_MAIN);
                sair.addCategory(Intent.CATEGORY_HOME);
                sair.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(sair);
            }

        });

        BancoSQLite banco = new BancoSQLite(this);

        ArrayAdapter<Profissional> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,banco.selecionartodosprofissionais());

        Lst_view.setAdapter(arrayAdapter);

        Lst_view.setOnItemClickListener((adapterView, view, i, l) -> {
            Btn_preenchaafichaanamneseacheoprofissional.setVisibility(View.VISIBLE);
        });
        Btn_voltardatelaacheoprofissional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent voltar = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(voltar);
            }
        });



        Btn_preenchaafichaanamneseacheoprofissional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id_login = getIntent().getExtras().getString("id_usuario");

                Intent anamnese = new Intent(getApplicationContext(), anamnese.class);
                anamnese.putExtra("id_usuario", id_login);
                startActivity(anamnese);
            }});

    }


        public void Btn_voltardatelaacheoprofissional (View v)
        {
            Intent main = new Intent(this, MainActivity.class);
            startActivity(main);
        }


}
