package com.example.desacelera.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.desacelera.database.BancoSQLite;
import com.example.desacelera1.R;
import com.exemple.desacelera.model.Profissional;

public class cadastro_profissional extends AppCompatActivity {

    Button Btn_cadastro_profissional;
    EditText Edt_nomeprofissionaldecadprofissional3;
    EditText Edt_sobrenomeprofissionaldecadprofissional3;
    EditText Edt_emailprofissionaldecadprofissional3;
    EditText Edt_datanascimentoprofissionaldecadprofissional3;
    EditText Edt_crmprofissionaldecadprofissional3;
    EditText Edt_senhaprofissionaldecadprofissional3;
    ImageButton Imgb_fecharcadastroprofissional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_profissional);

        Btn_cadastro_profissional = findViewById(R.id.btn_crieseucadastroprofissionaldecadprofissional);
        Edt_nomeprofissionaldecadprofissional3 = findViewById(R.id.edt_nomeprofissionaldecadprofissional3);
        Edt_sobrenomeprofissionaldecadprofissional3 = findViewById(R.id.edt_sobrenomeprofissionaldecadprofissional3);
        Edt_emailprofissionaldecadprofissional3 = findViewById(R.id.edt_emailprofissionaldecadprofissional3);
        Edt_datanascimentoprofissionaldecadprofissional3 = findViewById(R.id.edt_datanascimentoprofissionaldecadprofissional3);
        Edt_crmprofissionaldecadprofissional3 = findViewById(R.id.edt_crmprofissionaldecadprofissional3);
        Edt_senhaprofissionaldecadprofissional3 = findViewById(R.id.edt_senhaprofissionaldecadprofissional3);
        Imgb_fecharcadastroprofissional = findViewById(R.id.imgb_fecharcadastroprofissional);

       Imgb_fecharcadastroprofissional.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

            Intent sair = new Intent(Intent.ACTION_MAIN);
            sair.addCategory(Intent.CATEGORY_HOME);
            sair.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(sair);
        }

    });

        Btn_cadastro_profissional.setOnClickListener(view -> {

            BancoSQLite db = new BancoSQLite(this);

            if (db.inserirProfissional(new Profissional(Edt_nomeprofissionaldecadprofissional3.getText().toString(),
                    Edt_senhaprofissionaldecadprofissional3.getText().toString(),
                    Edt_emailprofissionaldecadprofissional3.getText().toString(),
                    Edt_crmprofissionaldecadprofissional3.getText().toString(),
                    Edt_sobrenomeprofissionaldecadprofissional3.getText().toString(),
                    Edt_datanascimentoprofissionaldecadprofissional3.getText().toString()
            )))
            {

                Toast.makeText( this,"Profissional cadastrado com sucesso!", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Não foi possível realizar o cadastro!", Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void btn_voltardateladecadastro_profissional(View v)
    {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}