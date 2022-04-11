package com.example.desacelera.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.exemple.desacelera.model.FichaAnamnese;
import com.exemple.desacelera.model.Musica;
import com.exemple.desacelera.model.Profissional;
import com.exemple.desacelera.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class BancoSQLite extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "Dados_desacelera.db";


    private static final String ID = "id";
    private static final String ID_LOGIN = "id_login";
    private static final String LOGIN = "login";
    private static final String SENHA = "senha";
    private static final String EMAIL = "email";
    private static final String TELEFONE = "telefone";
    private static final String SOBRENOME = "sobrenome";
    private static final String NASCIMENTO = "nascimento";
    private static final String CRM = "crm";

    private static final String TABELA = "usuarios";
    private static final String TABELA_PROFISSIONAL = "profissional";
    private static final String TABELA_ANAMNESE = "anamnese";
    private static final String TABELA_PLAYLIST = "playlist";
    private static final int VERSAO = 11;   //Toda vez que muda a tabela precisa incrementar 1 na versao
    private static final String OQUEESTASENTINDO = "oqueestasintindo";
    private static final String REPETIDOGRADUAL = "repetidogradual";
    private static final String QUANDOCOMECOU = "quandocomecou";
    private static final String QUAISSINTOMASJATEVE = "sintomas";
    private static final String NOME_MUSICA = "nomemusica";
    private static final String URL = "url";


    public BancoSQLite(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        criarTabelaUsuario(db);
        criarTabelaProfissional(db);
        criarTabelaFichaAnamnese(db);
        criarTabelaPlaylist(db);

    }

    private void criarTabelaPlaylist(SQLiteDatabase db) {
        String CREATE_PLAYLIST_TABLE = "CREATE TABLE " + TABELA_PLAYLIST + " ( " +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOME_MUSICA + " TEXT," +
                URL + " TEXT" + " ) ";

        db.execSQL(CREATE_PLAYLIST_TABLE);

    }

    public List<Musica> selecionarTodaPlaylist() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABELA_PLAYLIST,
                new String[]{ID, NOME_MUSICA, URL}, null, null, null, null, null, null);
        List<Musica> playlist = new ArrayList<>();
        if (cursor != null) {

            while (cursor.moveToNext()) {
                Musica musica = new Musica(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2));
                playlist.add(musica);
            }
        }
        return playlist;

    }


    public boolean inserirMusica(Musica u) {

        long result;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOME_MUSICA, u.getNomeMusica());
        values.put(URL, u.getUrl());


        result = db.insert(TABELA_PLAYLIST, null, values);
        db.close();

        if (result == -1)
            return false;
        else
            return true;

    }

    private void criarTabelaFichaAnamnese(SQLiteDatabase db) {

        String CREATE_ANAMNESE_TABLE = "CREATE TABLE " + TABELA_ANAMNESE + " ( " +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ID_LOGIN + " INTEGER, " +
                LOGIN + " TEXT," +
                OQUEESTASENTINDO + " TEXT," +
                REPETIDOGRADUAL + " TEXT," +
                QUANDOCOMECOU + " TEXT," +
                QUAISSINTOMASJATEVE + " TEXT" + " ) ";

        db.execSQL(CREATE_ANAMNESE_TABLE);
    }

    public void criarTabelaUsuario(SQLiteDatabase db) {

        String CREATE_USUARIOS_TABLE = "CREATE TABLE " + TABELA + " ( " +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LOGIN + " TEXT," +
                SENHA + " TEXT," +
                EMAIL + " TEXT," +
                TELEFONE + " TEXT," +
                SOBRENOME + " TEXT," +
                NASCIMENTO + " TEXT" + " ) ";


        db.execSQL(CREATE_USUARIOS_TABLE);

    }

    public void criarTabelaProfissional(SQLiteDatabase db) {

        String CREATE_PROFISSIONAL_TABLE = "CREATE TABLE " + TABELA_PROFISSIONAL + " ( " +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LOGIN + " TEXT," +
                SENHA + " TEXT," +
                EMAIL + " TEXT," +
                CRM + " TEXT," +
                SOBRENOME + " TEXT," +
                NASCIMENTO + " TEXT" + " ) ";


        db.execSQL(CREATE_PROFISSIONAL_TABLE);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_PROFISSIONAL);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_ANAMNESE);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_PLAYLIST);
        onCreate(db);

    }


    public boolean inserirUsuario(Usuario u) {
        long result;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LOGIN, u.getLogin());
        values.put(SENHA, u.getSenha());
        values.put(EMAIL, u.getEmail());
        values.put(TELEFONE, u.getTelefone());
        values.put(SOBRENOME, u.getSobrenome());
        values.put(NASCIMENTO, u.getNascimento());

        result = db.insert(TABELA, null, values);
        db.close();

        if (result == -1)
            return false;
        else
            return true;

    }

    public boolean inserirProfissional(Profissional u) {
        long result;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LOGIN, u.getLogin());
        values.put(SENHA, u.getPassword());
        values.put(EMAIL, u.getEmail());
        values.put(CRM, u.getCrm());
        values.put(SOBRENOME, u.getSobrenome());
        values.put(NASCIMENTO, u.getNascimento());

        result = db.insert(TABELA_PROFISSIONAL, null, values);
        db.close();

        if (result == -1)
            return false;
        else
            return true;

    }


    public Usuario selecionarUsuario(String login) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABELA,
                new String[]{ID, LOGIN, SENHA, EMAIL, TELEFONE, SOBRENOME, NASCIMENTO},
                LOGIN + " = ?",
                new String[]{String.valueOf(login)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();

            Usuario user = new Usuario(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6));

            return (Usuario) user.clone();
        } else {
            return null;
        }
    }


    public Profissional selecionarProfissional(String login) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABELA_PROFISSIONAL,
                new String[]{ID, LOGIN, SENHA, EMAIL, CRM, SOBRENOME, NASCIMENTO},
                LOGIN + " = ?",
                new String[]{String.valueOf(login)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();

            Profissional user = new Profissional(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6));

            return (Profissional) user.clone();
        } else {
            return null;
        }
    }

    public List<Profissional> selecionartodosprofissionais() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABELA_PROFISSIONAL,
                new String[]{ID, LOGIN, SENHA, EMAIL, CRM, SOBRENOME, NASCIMENTO}, null, null, null, null, null, null);
        List<Profissional> listaprofissional = new ArrayList<>();
        if (cursor != null) {

            while (cursor.moveToNext()) {
                Profissional user = new Profissional(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6));
                listaprofissional.add(user);
            }
        }
        return listaprofissional;
    }


    public Usuario selecionarUsuarioporId(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABELA,
                new String[]{ID, LOGIN, SENHA, EMAIL, TELEFONE, SOBRENOME, NASCIMENTO},
                ID + " = ?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();

            Usuario user = new Usuario(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6));

            return (Usuario) user.clone();
        } else
            return null;
    }


    public Profissional selecionarProfissionalporId(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABELA_PROFISSIONAL,
                new String[]{ID, LOGIN, SENHA, EMAIL, CRM, SOBRENOME, NASCIMENTO},
                ID + " = ?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();

            Profissional user = new Profissional(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6));

            return (Profissional) user.clone();
        } else
            return null;
    }

    public boolean inserirFichaAnamnese(FichaAnamnese ficha) {
        long result;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID_LOGIN, ficha.getId_usuario());
        values.put(LOGIN, ficha.getLoginNome());
        values.put(OQUEESTASENTINDO, ficha.getOquevoceestasentindo());
        values.put(REPETIDOGRADUAL, ficha.getRepetidoougradual());
        values.put(QUANDOCOMECOU, ficha.getQuandocomecou());
        values.put(QUAISSINTOMASJATEVE, ficha.getQuaissintomasjateve());

        result = db.insert(TABELA_ANAMNESE, null, values);
        db.close();

        if (result == -1)
            return false;
        else
            return true;

    }


    public List<FichaAnamnese> selecionarTodasFichas() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABELA_ANAMNESE,
                new String[]{ID, LOGIN, ID_LOGIN, OQUEESTASENTINDO, REPETIDOGRADUAL, QUANDOCOMECOU, QUAISSINTOMASJATEVE}, null, null, null, null, null, null);

        List<FichaAnamnese> fichas = new ArrayList<>();
        if (cursor != null) {

            while (cursor.moveToNext()) {
                FichaAnamnese user = new FichaAnamnese(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6));
                fichas.add(user);
            }
        }
        return fichas;
    }
}






