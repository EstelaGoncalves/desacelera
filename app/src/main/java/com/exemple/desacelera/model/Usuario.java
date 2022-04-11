package com.exemple.desacelera.model;

public class Usuario implements Cloneable {

    private int id;
    private String login;
    private String password;
    private String email;
    private String telefone;
    private String sobrenome;
    private String nascimento;


    public Usuario() {
    }

    public Usuario(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Usuario(String login, String password, String email, String telefone, String sobrenome, String nascimento) {
        this.login = login;
        this.password = password;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.sobrenome = sobrenome;
        this.email = email;
    }

    public Usuario(int id, String login, String password, String email, String telefone, String sobrenome, String nascimento) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.sobrenome = sobrenome;
        this.email = email;
    }

    public Usuario(Usuario u) {
        this.id = u.getId();
        this.login = u.getLogin();
        this.password = u.getSenha();
        this.nascimento = u.getNascimento();
        this.telefone = u.getTelefone();
        this.sobrenome = u.getSobrenome();
        this.email = u.getEmail();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String l) {
        this.login = l;
    }

    public String getSenha() {
        return this.password;
    }

    public void setSenha(String p) {
        this.password = p;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

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

        Usuario clone = new Usuario(this);

        return clone;
    }


}