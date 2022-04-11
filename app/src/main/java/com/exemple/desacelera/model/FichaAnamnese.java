package com.exemple.desacelera.model;

public class FichaAnamnese {

    private int id;
    private String loginNome;
    private int id_usuario;

    //Campos que estão na tela
    private String oquevoceestasentindo;
    private String repetidoougradual;
    private String quandocomecou;
    private String quaissintomasjateve;

    public FichaAnamnese(String loginNome, int id_usuario, String oquevoceestasentindo, String repetidoougradual, String quandocomecou, String quaissintomasjateve) {
        this.loginNome = loginNome;
        this.id_usuario = id_usuario;
        this.oquevoceestasentindo = oquevoceestasentindo;
        this.repetidoougradual = repetidoougradual;
        this.quandocomecou = quandocomecou;
        this.quaissintomasjateve = quaissintomasjateve;
    }

    public FichaAnamnese(int id, String loginNome, int id_usuario, String oquevoceestasentindo, String repetidoougradual, String quandocomecou, String quaissintomasjateve) {
        this.id = id;
        this.loginNome = loginNome;
        this.id_usuario = id_usuario;
        this.oquevoceestasentindo = oquevoceestasentindo;
        this.repetidoougradual = repetidoougradual;
        this.quandocomecou = quandocomecou;
        this.quaissintomasjateve = quaissintomasjateve;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginNome() {
        return loginNome;
    }

    public void setLoginNome(String loginNome) {
        this.loginNome = loginNome;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getOquevoceestasentindo() {
        return oquevoceestasentindo;
    }

    public void setOquevoceestasentindo(String oquevoceestasentindo) {
        this.oquevoceestasentindo = oquevoceestasentindo;
    }

    public String getRepetidoougradual() {
        return repetidoougradual;
    }

    public void setRepetidoougradual(String repetidoougradual) {
        this.repetidoougradual = repetidoougradual;
    }

    public String getQuandocomecou() {
        return quandocomecou;
    }

    public void setQuandocomecou(String quandocomecou) {
        this.quandocomecou = quandocomecou;
    }

    public String getQuaissintomasjateve() {
        return quaissintomasjateve;
    }

    public void setQuaissintomasjateve(String quaissintomasjateve) {
        this.quaissintomasjateve = quaissintomasjateve;
    }

    @Override
    public String toString(){

        String dados = String.format("NOME: %s",this.loginNome);

        return dados;
    }

}
