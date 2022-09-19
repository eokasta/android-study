package br.fmu.projetoaula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TipCalculatorActivity extends AppCompatActivity {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###.#");

    private EditText editTextValue;
    private SeekBar seekBar;
    private TextView textViewTipValue;
    private TextView textViewFinalValue;
    private TextView textViewTipPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        this.editTextValue = findViewById(R.id.editTextTipCalculatorValue);
        editTextValue.setText("0");
        setInteractValue();

        this.seekBar = findViewById(R.id.seekBarTipCalculatorTipPercent);
        this.textViewTipValue = findViewById(R.id.textViewTipValue);
        this.textViewFinalValue = findViewById(R.id.textViewFinalValue);
        this.textViewTipPercent = findViewById(R.id.textViewTipPercent);
        setInteractSeekBar();

        updateAll();
    }

    private void updateAll() {
        System.out.println("updating...");

        final int progress = seekBar.getProgress();
        final double percent = progress / 100D;
        int value;
        try {
            value = Integer.parseInt(editTextValue.getText().toString());
        } catch (NumberFormatException exception) {
            value = 0;
        }

        final double tip = value * percent;
        final double finalValue = value + tip;

        textViewTipPercent.setText(DECIMAL_FORMAT.format(progress) + "%");
        textViewTipValue.setText(String.format("R$ %s", DECIMAL_FORMAT.format(tip)));
        textViewFinalValue.setText(String.format("R$ %s", DECIMAL_FORMAT.format(finalValue)));

        System.out.println("updated!");
    }

    private void setInteractValue() {
        this.editTextValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                updateAll();
            }
        });
    }

    private void setInteractSeekBar() {
        this.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                System.out.println("CHANGED | progress = " + progress);
                updateAll();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                System.out.println("TRACKING TOUCH | progress = " + seekBar.getProgress());
                updateAll();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                System.out.println("STOP TRACKING TOUCH | progress = " + seekBar.getProgress());
                updateAll();
            }
        });
    }

}