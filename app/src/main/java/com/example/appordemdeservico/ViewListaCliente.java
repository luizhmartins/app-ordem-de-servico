package com.example.appordemdeservico;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * Classe que carrega o adapter/ Lista de Cliente
 *
 */
public class ViewListaCliente extends AppCompatActivity {

    ListView lvLista;
    List<Cliente> lista;
    ArrayAdapter adapter;
    Button btnMenuOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvLista = (ListView) findViewById(R.id.lvOrdemServico);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        ViewListaCliente.this, ViewCadastroCliente.class);
                startActivity(intent);
            }
        });

        btnMenuOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewListaCliente.this, MainActivity.class);
                startActivity(intent);
            }
        });

        lvLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final Cliente clienteSelecionado = lista.get(position);
                AlertDialog.Builder alerta =
                        new AlertDialog.Builder(ViewListaCliente.this);
                alerta.setTitle("Excluir Ordem de Serviço...");
                alerta.setMessage("Confirma a exclusão da Ordem de Serviço? " +
                        clienteSelecionado.getNome() + "?");
                alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        OrdemServicoDAO.excluir(clienteSelecionado.getId(),
                                ViewListaCliente.this);
                        carregarLista();

                    }
                });
                alerta.setNeutralButton("Cancelar", null);
                alerta.show();

                return true;
            }
        });

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Item clicado", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ViewListaCliente.this, ViewCadastroCliente.class); // criar a classe produto activity
                startActivity(intent);
            }
        });

    }

    private void carregarLista(){

        lista = ClienteDAO.listar(this);
        adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, lista );
        lvLista.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarLista();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
