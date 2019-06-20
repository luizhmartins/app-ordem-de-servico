package com.example.appordemdeservico;

<<<<<<< HEAD
public class OrdemServico {

    private int Id;
    private String Cliente;
    private String Tipo;
    private String Data;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }
}

=======
import java.util.Date;

public class OrdemServico {

    private int id;
    private int idcliente;
    private String tipoServico;
    private Date dataServico;
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

    public Date getDataServico() {
        return dataServico;
    }

    public void setDataServico(Date dataServico) {
        this.dataServico = dataServico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
>>>>>>> 4791a9475cca8ca36e74a0ea4657557eaec1260f
