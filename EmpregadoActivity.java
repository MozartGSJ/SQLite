package com.mozart.vale;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.mozart.vale.dao.BDControl;
import com.mozart.vale.vo.EmpregadoVo;

/**
 * Created by Mozart on 13/10/2016.
 */

public class EmpregadoActivity extends AppCompatActivity {

    private static EditText nome;
    private static EditText email;
    private static EditText senha;

    EmpregadoVo empregado = new EmpregadoVo();

    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empregado);

        nome = (EditText)findViewById(R.id.nomeText);
        email = (EditText)findViewById(R.id.emailText);
        senha = (EditText)findViewById(R.id.senhaText);


    }

    public void salvar(View view){
        empregado.setNome(nome.getText().toString());
        empregado.setEmail(email.getText().toString());
        empregado.setSenha(senha.getText().toString());

        BDControl bd = new BDControl(this);
        bd.addEmpregado(empregado);
    }

    public void editar(View view){
        empregado.setNome(nome.getText().toString());
        empregado.setEmail(email.getText().toString());
        empregado.setSenha(senha.getText().toString());

        BDControl bd = new BDControl(this);
        bd.atualizar(empregado);
    }

}

