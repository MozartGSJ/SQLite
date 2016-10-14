package com.mozart.vale.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.mozart.vale.CadastroActivity;
import com.mozart.vale.PrincipalActivity;
import com.mozart.vale.vo.EmpregadoVo;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Mozart on 13/10/2016.
 */

public class BDControl {

    private static DBHelper dbHelper = null;
    private static SQLiteDatabase bd ;

    public BDControl(Context context){
        if (dbHelper == null){
            dbHelper = new DBHelper(context);
            bd = dbHelper.getWritableDatabase();
        }
    }

    public String addEmpregado(EmpregadoVo empregado){
        String msg;
        try {
            ContentValues valores = new ContentValues();
            valores.put("nome", empregado.getNome());
            valores.put("matricula", empregado.getMatricula());
            valores.put("senha", empregado.getSenha());
            valores.put("email", empregado.getEmail());

            bd.insert("empregado", null, valores);

            msg = "Cadastro inserido com sucesso";
        }catch (Exception e){
            msg = "Erro: "+ e;
        }
        return msg;
    }

    public void atualizar(EmpregadoVo empregado){
        ContentValues valores = new ContentValues();
        valores.put("nome",empregado.getNome());
        valores.put("email",empregado.getEmail());

        bd.update("empregado",valores,"_id_empregado = ?", new String[]{""+empregado.getId_empregado()});
    }

    public void deletar(EmpregadoVo empregado){
        bd.delete("empregado", "_id_empregado = "+empregado.getId_empregado(),null);
    }

    public List<EmpregadoVo> allEmpregados(){
        List<EmpregadoVo> list = new ArrayList<EmpregadoVo>();

        try {
            String[] colunas = new String[]{"_id_empregado", "nome", "email"};
            Cursor cursor = bd.query("empregado", colunas, null, null, null, null, "nome ASC");

            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                do {
                    EmpregadoVo e = new EmpregadoVo();
                    e.setId_empregado((int) cursor.getLong(0));
                    e.setNome(cursor.getString(1));
                    e.setMatricula(cursor.getString(2));
                    e.setEmail(cursor.getString(3));
                    list.add(e);
                } while (cursor.moveToNext());
            }
        }catch (Exception e){

        }
        return list;
    }

    public ArrayList<String> getAllAtividade(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<String> atividades = null;
        String sql = "SELECT * FROM ATIVIDADE";
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor != null && cursor.moveToFirst()){
            atividades = new ArrayList<String>();

            do{
                atividades.add(cursor.getString(1));
            }while (cursor.moveToNext());
        }
        return atividades;
    }

    public EmpregadoVo getLogin(String matricula, String senha){

        EmpregadoVo empregado = new EmpregadoVo();
        String[] colunas = new String[]{"*"};
        String where = ("matricula = '" + matricula + "' and senha = '" +senha+"'");
        Cursor cursor = bd.query("EMPREGADO",colunas,where,null,null,null,null);

        if(cursor != null && cursor.moveToFirst()){
            empregado.setId_empregado(cursor.getInt(0));
            empregado.setNome(cursor.getString(1));
            empregado.setMatricula(cursor.getString(2));
            empregado.setEmail(cursor.getString(3));
            empregado.setSenha(cursor.getString(4));
        }
        return empregado;
    }
}
