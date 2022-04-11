package com.exemple.desacelera.model;

public class Musica {

    private int id;
    private String nomeMusica;
    private String url;

    public Musica(int id, String nomeMusica, String url) {
        this.id = id;
        this.nomeMusica = nomeMusica;
        this.url = url;
    }

    public Musica(String nomeMusica, String url) {
        this.nomeMusica = nomeMusica;
        this.url = url;
    }

    public Musica(Musica musica) {
        this.id = musica.getId();
        this.nomeMusica = musica.getNomeMusica();
        this.url = musica.getUrl();


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    protected Object clone() {

        Musica clone = new Musica(this);

        return clone;
    }

    @Override
    public String toString(){

        String dados = String.format("Musica: %s ",this.nomeMusica);

        return dados;
    }
}
