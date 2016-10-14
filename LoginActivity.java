package com.mozart.vale;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.mozart.vale.dao.BDControl;
import com.mozart.vale.vo.EmpregadoVo;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText matricula = (EditText)findViewById(R.id.matricula);
        final EditText senha = (EditText)findViewById(R.id.password);

        Button btLogin = (Button)findViewById(R.id.bt_login);
        Button btCadastro = (Button)findViewById(R.id.bt_cadastro);

        btLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if((matricula.getText().length()==0)||(senha.getText().length()==0)){
                    Toast.makeText(LoginActivity.this, "Campos obrigatorios não preenchidos",
                            Toast.LENGTH_LONG).show();
                }else{
                    try {
                        EmpregadoVo emp = new EmpregadoVo();
                        emp = verlogin(LoginActivity.this, matricula.getText().toString(), senha.getText().toString());

                        if (emp != null) {
                            Toast.makeText(LoginActivity.this, "Login efetuado com sucesso",
                                    Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginActivity.this, PrincipalActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Login efetuado com sucesso",
                                    Toast.LENGTH_LONG).show();
                        }
                    }catch (Exception e){
                        FrameLayout frame = (FrameLayout)findViewById(R.id.frame_login);
                        frame.setVisibility(View.VISIBLE);
                        Toast.makeText(LoginActivity.this, "Login efetuado com sucesso",
                                Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this,PrincipalActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,CadastroActivity.class);
                startActivity(intent);
            }
        });
    }

    private EmpregadoVo verlogin(Context context, String matricula, String senha){
        EmpregadoVo empregado = new EmpregadoVo();
        BDControl bdControl = new BDControl(context);
        empregado = bdControl.getLogin(matricula,senha);
        return empregado;
    }

}


