package com.example.appordemdeservico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActOS extends AppCompatActivity {

    private EditText edtClienteOS;
    private EditText edtTipoOS;
    private EditText edtDataOS;
    private EditText edtValorOS;
    private EditText edtDescricaoOS;
    private Button btnSalvarOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_os);

        edtClienteOS = (EditText) findViewById(R.id.edtClienteOS);
        edtTipoOS = (EditText) findViewById(R.id.edtTipoOS);
        edtDataOS = (EditText) findViewById(R.id.edtDataOS);
        edtValorOS = (EditText) findViewById(R.id.edtValorOS);
        edtDescricaoOS = (EditText) findViewById(R.id.edtDescricaoOS);
        btnSalvarOS = (Button) findViewById(R.id.btnSalvarOS);

        btnSalvarOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }

    private void salvar(){
        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setIdcliente(Integer.parseInt(edtClienteOS.getText().toString()));
        ordemServico.setValor(Double.valueOf(edtValorOS.getText().toString()));
        ordemServico.setTipoServico( edtTipoOS.getText().toString() );

        OrdemServicoDAO.inserir(ordemServico, this);
        this.finish();
    }
}
