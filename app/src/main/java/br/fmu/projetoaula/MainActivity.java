package br.fmu.projetoaula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumero1;
    private EditText editTextNumero2;
    private EditText editTextResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumero1 = findViewById(R.id.editTextNumero1);
        editTextNumero2 = findViewById(R.id.editTextNumero2);
        editTextResultado = findViewById(R.id.editTextResultado);
    }

    public void somar(View view ) {
        int numero1 = Integer.parseInt(editTextNumero1.getText().toString());
        int numero2 = Integer.parseInt(editTextNumero2.getText().toString());
        int soma = numero1 + numero2;
        editTextResultado.setText(Integer.toString(soma));
    }
}