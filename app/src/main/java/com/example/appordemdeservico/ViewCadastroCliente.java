package com.example.appordemdeservico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ViewCadastroCliente extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtTelefone;
    private EditText edtEndereco;
    private Button btnCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        edtNome = (EditText)findViewById(R.id.edtNome);
        edtTelefone = (EditText)findViewById(R.id.edtTelefone);
        edtEndereco = (EditText)findViewById(R.id.edtEndereco);
        btnCadastro = (Button)findViewById(R.id.btnCadastro);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }

    private void salvar(){
        Cliente cliente = new Cliente();
        cliente.setNome( edtNome.getText().toString() );
        cliente.setTelefone( edtTelefone.getText().toString() );
        cliente.setEndereco( edtEndereco.getText().toString() );

        ClienteDAO.inserir(cliente, this);
        this.finish();
    }
}
