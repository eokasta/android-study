package br.fmu.projetoaula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import br.fmu.projetoaula.util.ActivityUtil;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void back(View view) {
        ActivityUtil.openActivity(this, MainActivity.class);
    }

}