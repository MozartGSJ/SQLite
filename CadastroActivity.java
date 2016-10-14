package com.mozart.vale;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.mozart.vale.dao.BDControl;
import com.mozart.vale.vo.EmpregadoVo;
public class CadastroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        final EditText nome = (EditText)findViewById(R.id.txt_nome);
        final EditText matricula = (EditText)findViewById(R.id.txt_matricula);
        final EditText email = (EditText)findViewById(R.id.txt_email);
        final EditText senha = (EditText)findViewById(R.id.txt_senha);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.bt_salvar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nome.getText().toString().isEmpty() || matricula.getText().toString().isEmpty() ||
                        email.getText().toString().isEmpty() || senha.getText().toString().isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Campos obrigatorios não preenchidos",
                            Toast.LENGTH_LONG).show();
                } else {
                    EmpregadoVo emp = new EmpregadoVo();

                    emp.setNome(nome.getText().toString());
                    emp.setMatricula(matricula.getText().toString());
                    emp.setEmail(email.getText().toString());
                    emp.setSenha(senha.getText().toString());

                    BDControl bd = new BDControl(CadastroActivity.this);
                    String msg = bd.addEmpregado(emp);

                    Toast.makeText(CadastroActivity.this, msg,
                            Toast.LENGTH_LONG).show();

                    if (msg.equals("Cadastro inserido com sucesso")) {
                        Intent intent = new Intent(CadastroActivity.this, PrincipalActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(CadastroActivity.this, msg,
                                Toast.LENGTH_LONG).show();
                    }
                    finish();
                }
            }
        });
    }
}
