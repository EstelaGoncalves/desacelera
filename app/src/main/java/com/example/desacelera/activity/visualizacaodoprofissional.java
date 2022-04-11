package com.example.desacelera.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.desacelera.database.BancoSQLite;
import com.example.desacelera1.R;

public class visualizacaodoprofissional<chipatendidovisualizacaodoprofissional, bnt_voltardateladevisualizacaodoprofissional> extends AppCompatActivity {

    ListView Lst_anamnesevisualizacaodoprofissional;
    ImageView Imgv_fecharvisualizacaodoprofissional;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizacaodoprofissional);

        Lst_anamnesevisualizacaodoprofissional = findViewById(R.id.lst_anamnesevisualizacaodoprofissional);
        Imgv_fecharvisualizacaodoprofissional = findViewById(R.id.imgv_fecharvisualizacaodoprofissional);

        Imgv_fecharvisualizacaodoprofissional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent sair = new Intent(Intent.ACTION_MAIN);
                    sair.addCategory(Intent.CATEGORY_HOME);
                    sair.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(sair);
                }

        });

        carregarFichasAnamnese();


    }

    private void carregarFichasAnamnese() {

        BancoSQLite banco = new BancoSQLite(this);

        ArrayAdapter<String> fichaAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,banco.selecionarTodasFichas());

        Lst_anamnesevisualizacaodoprofissional.setAdapter(fichaAdapter);

    }


}