package br.fmu.projetoaula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import org.jetbrains.annotations.NotNull;

import br.fmu.projetoaula.util.ActivityUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openLoginActivity(View view) {
        ActivityUtil.openActivity(this, LoginActivity.class);
    }

    public void openSignUpActivity(View view) {
        ActivityUtil.openActivity(this, SignUpActivity.class);
    }

    public void openTipCalculatorActivity(View view) {
        ActivityUtil.openActivity(this, TipCalculatorActivity.class);
    }

}