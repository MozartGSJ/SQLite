package com.mozart.vale.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Mozart on 12/10/2016.
 */

class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "DATA_APP";
    private static final int DB_VERSION = 3;

    private static DBHelper dbHelper = null;

    private static String TABLE_EMPREGADOS = "CREATE TABLE EMPREGADO("
            +" _idEmpregado INTEGER PRIMARY KEY AUTOINCREMENT, "
            +"nome TEXT NOT NULL, "
            +"matricula TEXT NOT NULL, "
            +"email TEXT NOT NULL, "
            +"senha TEXT NOT NULL"
            +");";

    private static String TABLE_EQUIPAMENTO = "CREATE TABLE EQUIPAMENTO("
            +" _id_equipamento INTEGER PRIMARY KEY AUTOINCREMENT, "
            +" nome TEXT NOT NULL, "
            +" patrimonio TEXT NOT NULL, "
            +" local_origem TEXT NOT NULL, "
            +" local_atual TEXT NOT NULL, "
            +" descricao TEXT NOT NULL"
            +");";

    private static String TABLE_LOCAL = "CREATE TABLE LOCAL("
            +" _d_local INTEGER PRIMARY KEY AUTOINCREMENT, "
            +" descricao TEXT NOT NULL, "
            +" km_inicial TEXT NOT NULL, "
            +" km_final TEXT NOT NULL "
            +")";

    private static String TABLE_ATIVIDADE = "CREATE TABLE ATIVIDADE("
            +" _id_atividade INTEGER PRIMARY KEY AUTOINCREMENT, "
            +" descricao TEXT NOT NULL, "
            +" data TEXT NOT NULL, "
            +" hora TEXT NOT NULL, "
            +" linha TEXT NOT NULL, "
            +" id_local_atividade INTEGER REFERENCES LOCAL(id_local) "
            +");";

    public DBHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_EMPREGADOS);
        db.execSQL(TABLE_EQUIPAMENTO);
        db.execSQL(TABLE_LOCAL);
        db.execSQL(TABLE_ATIVIDADE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int OLD_VERSION, int NEW_VERSION) {
        db.delete("empregado",null,null);
        onCreate(db);
    }

}
