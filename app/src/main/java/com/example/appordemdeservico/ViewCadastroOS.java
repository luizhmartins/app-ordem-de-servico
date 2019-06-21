package com.example.appordemdeservico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

public class ViewCadastroOS extends AppCompatActivity {

    private EditText edtClienteOS;
    private EditText edtTipoOS;
    private CalendarView calendarViewDataOS;
    private EditText edtValor;
    private Button btnSalvarOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_os);

        edtClienteOS = (EditText)findViewById(R.id.edtClienteOS);
        edtTipoOS = (EditText)findViewById(R.id.edtTipoOS);
        edtValor = (EditText)findViewById(R.id.edtValorOS);
        calendarViewDataOS = (CalendarView) findViewById(R.id.calendarViewDataOS);
        btnSalvarOS = (Button)findViewById(R.id.btnSalvarOS);

        btnSalvarOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }

    private void salvar(){
        OrdemServico os = new OrdemServico();
        os.setIdcliente(Integer.parseInt(edtClienteOS.getText().toString()) );
        //os.setDescricao( edt.getText().toString() );
        os.setTipoServico( edtTipoOS.getText().toString() );
        //os.getDataServico( edtData);
        os.setValor( Double.parseDouble(edtValor.getText().toString()));

        OrdemServicoDAO.inserir(os, this);
        this.finish();
    }
}

