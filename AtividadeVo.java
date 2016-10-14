package com.mozart.vale.vo;

import java.util.Date;

/**
 * Created by Mozart on 13/10/2016.
 */

public class AtividadeVo {

    private int id_atividade;
    private String desc_atividade;
    private String data_atividade;
    private String hora_atividade;
    private String linha_atividade;
    private int id_local;

    public int getId_atividade() {
        return id_atividade;
    }

    public void setId_atividade(int id_atividade) {
        this.id_atividade = id_atividade;
    }

    public String getDesc_atividade() {
        return desc_atividade;
    }

    public void setDesc_atividade(String desc_atividade) {
        this.desc_atividade = desc_atividade;
    }

    public String getData_atividade() {
        return data_atividade;
    }

    public void setData_atividade(String data_atividade) {
        this.data_atividade = data_atividade;
    }

    public String getHora_atividade() {
        return hora_atividade;
    }

    public void setHora_atividade(String hora_atividade) {
        this.hora_atividade = hora_atividade;
    }

    public String getLinha_atividade() {
        return linha_atividade;
    }

    public void setLinha_atividade(String linha_atividade) {
        this.linha_atividade = linha_atividade;
    }

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }
}
