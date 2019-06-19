package com.example.appordemdeservico;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public static final void inserir(Cliente cliente, Context context){
        Banco banco = new Banco(context);
        ContentValues valores = new ContentValues();
        valores.put("nome", cliente.getNome() );
        valores.put("telefone", cliente.getTelefone() );
        valores.put("endereco", cliente.getEndereco() );

        SQLiteDatabase db = banco.getWritableDatabase();
        db.insert("anotacoes", null, valores);
    }

    public static final void excluir(int idNota, Context context){
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("anotacoes", "id = "+idNota, null);
    }

    public static final List<Cliente> listar(Context context){
        List<Cliente> lista = new ArrayList<>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        String sql = "SELECT * FROM anotacoes ORDER BY id DESC ";
        Cursor cursor = db.rawQuery(sql, null);
        if ( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Cliente cliente = new Cliente();
                cliente.setId( cursor.getInt( 0 ) );
                cliente.setNome( cursor.getString(1));
                cliente.setTelefone( cursor.getString(2));
                cliente.setEndereco( cursor.getString(3));

                lista.add( cliente );
            }while ( cursor.moveToNext() );
        }
        return lista;
    }



}
