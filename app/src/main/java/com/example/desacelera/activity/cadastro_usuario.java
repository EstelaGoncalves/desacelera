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
import com.exemple.desacelera.model.Usuario;

public class cadastro_usuario extends AppCompatActivity {


    Button Btn_crieseucadastrousuariocadastro;
    EditText Edt_nomedeusuariocadastro;
    EditText Edt_sobrenomedeusuariocadastro;
    EditText Edt_emaildeusuariocadastro;
    EditText Edt_telefonedeusuariocadastro;
    EditText Edt_datanascimentodeusuariocadastro;
    EditText Edt_senhadeusuariocadastro;
    ImageButton Imgv_fecharcadastrousuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        Btn_crieseucadastrousuariocadastro = findViewById(R.id.btn_crieseucadastrousuariocadastro);
        Edt_nomedeusuariocadastro = findViewById(R.id.edt_nomedeusuariocadastro);
        Edt_sobrenomedeusuariocadastro = findViewById(R.id.edt_sobrenomedeusuariocadastro);
        Edt_emaildeusuariocadastro = findViewById(R.id.edt_emaildeusuariocadastro);
        Edt_telefonedeusuariocadastro = findViewById(R.id.edt_telefonedeusuariocadastro);
        Edt_datanascimentodeusuariocadastro = findViewById(R.id.edt_datanascimentodeusuariocadastro);
        Edt_senhadeusuariocadastro = findViewById(R.id.edt_senhadeusuariocadastro);
        Imgv_fecharcadastrousuario = findViewById(R.id.imgv_fecharcadastrousuario);

        Imgv_fecharcadastrousuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sair = new Intent(Intent.ACTION_MAIN);
                sair.addCategory(Intent.CATEGORY_HOME);
                sair.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(sair);
            }});

        Btn_crieseucadastrousuariocadastro.setOnClickListener(view -> {
            BancoSQLite db = new BancoSQLite(this);

            if (db.inserirUsuario(new Usuario(Edt_nomedeusuariocadastro.getText().toString(),
                    Edt_senhadeusuariocadastro.getText().toString(),
                    Edt_emaildeusuariocadastro.getText().toString(),
                    Edt_telefonedeusuariocadastro.getText().toString(),
                    Edt_sobrenomedeusuariocadastro.getText().toString(),
                    Edt_datanascimentodeusuariocadastro.getText().toString()
            )))
            {

                Toast.makeText( this,"Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Não foi possível realizar o cadastro!", Toast.LENGTH_SHORT).show();
            }

        });




    }

    public void btn_voltardateladecadastro_usuario(View v)
    {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}

