package com.example.desacelera.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.desacelera.database.BancoSQLite;
import com.example.desacelera1.R;
import com.exemple.desacelera.model.Profissional;
import com.exemple.desacelera.model.Usuario;

public class login extends AppCompatActivity {

   ImageButton Btn_voltardateladelogin;
   EditText Edt_emaildeusuariologin;
   EditText Edt_senhadeusuariologin;
   Button Btn_entrarlogindeusuariologin;
   Button Btn_cadastrarlogin;
   CheckBox Ckb_usuariologin;
   ImageButton Img_sairlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Btn_voltardateladelogin = findViewById(R.id.btn_voltardateladelogin);
        Edt_emaildeusuariologin = findViewById(R.id.edt_emaildeusuariologin);
        Edt_senhadeusuariologin = findViewById(R.id.edt_senhadeusuariologin);
        Btn_entrarlogindeusuariologin = findViewById(R.id.btn_entrarlogindeusuariologin);
        Btn_cadastrarlogin = findViewById(R.id.btn_cadastrarlogin);
        Ckb_usuariologin = findViewById(R.id.ckb_usuariologin);
        Img_sairlogin = findViewById(R.id.img_sairlogin);

        Img_sairlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sair = new Intent(Intent.ACTION_MAIN);
                sair.addCategory(Intent.CATEGORY_HOME);
                sair.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(sair);
            }

        });

        Btn_entrarlogindeusuariologin.setOnClickListener(view -> {
            BancoSQLite b = new BancoSQLite(this);
            try{

                if (Ckb_usuariologin.isChecked() == true){

                    Usuario usuario = b.selecionarUsuario(Edt_emaildeusuariologin.getText().toString());
                    if (Edt_senhadeusuariologin.getText().toString().equals(usuario.getSenha())){
                        Intent intent = new Intent(getApplicationContext(), acheoprofissional.class);
                        intent.putExtra("id_usuario",Integer.toString(usuario.getId()));
                        startActivity(intent);
                    }else{
                        Toast.makeText(this, "Usuario Nao Cadastrado", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Profissional profissional = b.selecionarProfissional(Edt_emaildeusuariologin.getText().toString());
                    if (Edt_senhadeusuariologin.getText().toString().equals(profissional.getPassword())){
                        Intent intent = new Intent(getApplicationContext(), visualizacaodoprofissional.class);
                        intent.putExtra("id_profissional",Integer.toString(profissional.getId()));
                        startActivity(intent);
                    }else{
                        Toast.makeText(this, "Profissional Nao Cadastrado", Toast.LENGTH_SHORT).show();
                    }
                }
            }catch (Exception e){
                Toast.makeText(this, "Usuario/Profissional Nao Cadastrado", Toast.LENGTH_SHORT).show();
            }
        });


        Btn_voltardateladelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent voltar = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(voltar);
            }
        });

     Btn_cadastrarlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cadastrar = new Intent(getApplicationContext(), escolha_usu_prof.class);
            startActivity(cadastrar);
            }
        });

    }
    public void btn_voltardateladelogin(View v)
    {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}