package com.exemple.desacelera.model;

public class Profissional implements Cloneable{

    private int id;
    private String login;
    private String password;
    private String email;
    private String crm;
    private String sobrenome;
    private String nascimento;

    public Profissional() {
    }

    public Profissional(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Profissional(String login, String password, String email, String crm, String sobrenome, String nascimento) {
        this.login = login;
        this.password = password;
        this.nascimento = nascimento;
        this.crm = crm;
        this.sobrenome = sobrenome;
        this.email = email;
    }

    public Profissional(int id, String login, String password, String email, String crm, String sobrenome, String nascimento) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nascimento = nascimento;
        this.crm = crm;
        this.sobrenome = sobrenome;
        this.email = email;
    }

    public Profissional(Profissional u) {
        this.id = u.getId();
        this.login = u.getLogin();
        this.password = u.getPassword();
        this.nascimento = u.getNascimento();
        this.crm = u.getCrm();
        this.sobrenome = u.getSobrenome();
        this.email = u.getEmail();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCrm() { return crm; }

    public void setCrm(String crm) { this.crm = crm; }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public Object clone() {

        Profissional clone = new Profissional(this);

        return clone;
    }

    @Override
    public String toString(){

        String dados = String.format("NOME: %s     CRM: %s     EMAIL: %s",this.login, this.crm, this.email);

        return dados;
    }


}


