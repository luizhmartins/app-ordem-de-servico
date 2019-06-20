package com.example.appordemdeservico;

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

