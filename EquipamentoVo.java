package com.mozart.vale.vo;

/**
 * Created by Mozart on 13/10/2016.
 */

public class EquipamentoVo {

    private int id_equipamento;
    private String nm_equi;
    private String patrimonio;
    private String local_origem;
    private String local_atual;
    private  String desc_equi;

    public int getId_equipamento() {
        return id_equipamento;
    }

    public void setId_equipamento(int id_equipamento) {
        this.id_equipamento = id_equipamento;
    }

    public String getNm_equi() {
        return nm_equi;
    }

    public void setNm_equi(String nm_equi) {
        this.nm_equi = nm_equi;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getLocal_origem() {
        return local_origem;
    }

    public void setLocal_origem(String local_origem) {
        this.local_origem = local_origem;
    }

    public String getDesc_equi() {
        return desc_equi;
    }

    public void setDesc_equi(String desc_equi) {
        this.desc_equi = desc_equi;
    }

    public String getLocal_atual() {
        return local_atual;
    }

    public void setLocal_atual(String local_atual) {
        this.local_atual = local_atual;
    }

}
