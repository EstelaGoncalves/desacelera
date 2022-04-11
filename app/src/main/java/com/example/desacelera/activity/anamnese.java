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
import com.exemple.desacelera.model.FichaAnamnese;
import com.exemple.desacelera.model.Usuario;

public class anamnese extends AppCompatActivity {

    ImageButton IgmBtn_sairAnaminese;
    EditText Edt_oquevoceestasentindoanamnese;
    EditText Edt_repetidoougradualanamnese;
    EditText Edt_quandocomecouanamnese;
    EditText Edt_quaissintomasjateveanamnese;
    Button Btn_enviarfichadeanamnese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese);

        IgmBtn_sairAnaminese = findViewById(R.id.img_sairanamnese);
        Edt_oquevoceestasentindoanamnese = findViewById(R.id.edt_oquevoceestasentindoanamnese);
        Edt_repetidoougradualanamnese = findViewById(R.id.edt_repetidoougradualanamnese);
        Edt_quandocomecouanamnese= findViewById(R.id.edt_quandocomecouanamnese);
        Edt_quaissintomasjateveanamnese = findViewById(R.id.edt_quaissintomasjateveanamnese);
        Btn_enviarfichadeanamnese = findViewById(R.id.btn_enviarfichadeanamnese);

        Btn_enviarfichadeanamnese.setOnClickListener(view -> {
            BancoSQLite banco = new BancoSQLite(this);

            Usuario u = banco.selecionarUsuarioporId(getIntent().getStringExtra("id_usuario"));

            FichaAnamnese ficha = new FichaAnamnese(u.getLogin(),
                                                    u.getId(),
                                                    Edt_oquevoceestasentindoanamnese.getText().toString(),
                                                    Edt_repetidoougradualanamnese.getText().toString(),
                                                    Edt_quandocomecouanamnese.getText().toString(),
                                                    Edt_quaissintomasjateveanamnese.getText().toString());

            if (banco.inserirFichaAnamnese(ficha)){
                Toast.makeText(this, "Ficha anamnese gravada com sucesso!", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this, "Ficha anamnese não cadastrada.", Toast.LENGTH_SHORT).show();

        });

        IgmBtn_sairAnaminese.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent sair = new Intent(Intent.ACTION_MAIN);
                sair.addCategory(Intent.CATEGORY_HOME);
                sair.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(sair);
            }

        });




    }
    public void btn_voltardateladefichaanamnese(View v)
    {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}