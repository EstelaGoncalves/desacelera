package com.example.desacelera.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.desacelera.database.BancoSQLite;
import com.example.desacelera1.R;
import com.exemple.desacelera.model.Musica;

import java.util.List;

public class playlistActivity extends AppCompatActivity {

    ImageButton Btn_voltardateladeplaylist;
    ListView Lst_playlist;
    ImageButton Img_sairplaylist;

    static final String KEY_IS_FIRST_TIME =  "com.example.desacelera1.first_time";
    static final String KEY =  "com.example.desacelera1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        BancoSQLite b = new BancoSQLite(this);

        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getBoolean(KEY_IS_FIRST_TIME, true)){
            inserirMusicas(b);
            getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putBoolean(KEY_IS_FIRST_TIME, false).commit();
        }


        Btn_voltardateladeplaylist = findViewById(R.id.btn_voltardateladeplaylist);
        Lst_playlist = findViewById(R.id.lst_playlist);
        Img_sairplaylist = findViewById(R.id.img_sairplaylist);

        Img_sairplaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sair = new Intent(Intent.ACTION_MAIN);
                sair.addCategory(Intent.CATEGORY_HOME);
                sair.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(sair);
            }

        });



        List<Musica> lista = b.selecionarTodaPlaylist();

        ArrayAdapter<Musica> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lista);
        Lst_playlist.setAdapter(adapter);


        Btn_voltardateladeplaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent voltarplaylist = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(voltarplaylist);
            }


        });
    }

    private void inserirMusicas(BancoSQLite b) { Musica m0 = new Musica("Weightless", "https://www.youtube.com/watch?v=UfcAVejslrU");
        Musica m1 = new Musica("Electra", "https://www.youtube.com/watch?v=FTvZ8a2gHFc");
        Musica m2 = new Musica("Mellomaniac (Chill Out Mix)", "https://www.youtube.com/watch?v=EcRXlM6edrM");
        Musica m3 = new Musica("Watermark", "https://www.youtube.com/watch?v=NO5tb20qQnA");
        Musica m4 = new Musica("Strawberry Swing", "https://www.youtube.com/watch?v=isH1yy8I_dc");
        Musica m5 = new Musica("Please Don’t Go", "https://www.youtube.com/watch?v=COqx-TCxrSk");
        Musica m6 = new Musica("Pure Shores", "https://www.youtube.com/watch?v=dVNdTXEJv1A");
        Musica m7 = new Musica("Someone Like You", "https://www.youtube.com/watch?v=NAc83CF8Ejk");
        Musica m8 = new Musica("Canzonetta Sull’aria", "https://www.youtube.com/watch?v=Fc3fmSSUwck");
        Musica m9 = new Musica("We Can Fly", "https://www.youtube.com/watch?v=rbzuesSeDmQ");
        b.inserirMusica(m0);
        b.inserirMusica(m1);
        b.inserirMusica(m2);
        b.inserirMusica(m3);
        b.inserirMusica(m4);
        b.inserirMusica(m5);
        b.inserirMusica(m6);
        b.inserirMusica(m7);
        b.inserirMusica(m8);
        b.inserirMusica(m9);

    }

    public void btn_voltardateladeplaylist(View v)
    {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}