package com.example.appordemdeservico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ActOS extends AppCompatActivity {

    private EditText edtClienteOS;
    private EditText edtTipoOS;
    private EditText edtDataOS;
    private Button btnSalvarOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_os);

        edtClienteOS = (EditText)findViewById(R.id.edtClienteOS);
        edtTipoOS = (EditText)findViewById(R.id.edtTipoOS);
        edtDataOS = (EditText)findViewById(R.id.edtDataOS);
        btnSalvarOS = (Button)findViewById(R.id.btnSalvarOS);
    }
}
