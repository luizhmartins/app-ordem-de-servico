package com.example.appordemdeservico;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.system.Os;

import java.util.ArrayList;
import java.util.List;

public class OrdemServicoDAO {

    public static final void inserir(OrdemServico os, Context context){
        Banco banco = new Banco(context);
        ContentValues valores = new ContentValues();
        valores.put("cliente", os.getIdcliente() );
        valores.put("tipo", os.getTipoServico() );
        valores.put("data", os.getDataServico() );
        valores.put("valor", os.getValor() );
        valores.put("descrição", os.getDescricao() );

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
                OrdemServico os = new OrdemServico();
                os.setId( cursor.getInt( 0 ) );
                os.setIdcliente( cursor.getString(1));
                os.setTipoServico( cursor.getString(2));
                os.setDataServico( cursor.getString(3));
                os.setValor( cursor.getString(4));
                os.setDescricao( cursor.getString(5));

                lista.add(os);
            }while ( cursor.moveToNext() );
        }
        return lista;
    }
}

