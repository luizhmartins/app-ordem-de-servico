package com.example.appordemdeservico;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "os";
    private static final int VERSAO_BANCO = 2;

    public Banco(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Cliente ( " +
                "  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                "  nome TEXT , " +
                "  telefone TEXT , " +
                "  endereco TEXT  ) " );

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS OrdemServico ( " +
                "  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                "  id_Cliente INTEGER NOT NULL , " +
                "  tipoServico TEXT , " +
                "  dataServico TEXT , " +
                "  valor REAL , " +
                "  descricao TEXT , " +
                "  FOREIGN KEY (id_Cliente) REFERENCES Cliente(id)) " );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
