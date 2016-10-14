package com.mozart.vale.vo;

/**
 * Created by Mozart on 13/10/2016.
 */

public class EmpregadoVo {

    private int id_empregado;
    private String nome;
    private String matricula;
    private String senha;
    private String email;
    private int id_equipe;

    public int getId_empregado() {
        return id_empregado;
    }

    public void setId_empregado(int id_empregado) {
        this.id_empregado = id_empregado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

}
