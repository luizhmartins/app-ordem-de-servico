package com.example.appordemdeservico;

public class OrdemServico {

    private int id;
    private int idcliente;
    private String tipoServico;
    //private Date dataServico;
    private double valor;
    private String descricao;

    public OrdemServico() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

   // public int getDataServico() {
        //return dataServico;
   // }

    //public void setDataServico(Date dataServico) {
      //  this.dataServico = dataServico;
    //}

    public double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataServico(double aDouble) {
    }
}