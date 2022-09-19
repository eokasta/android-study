package br.fmu.projetoaula;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import br.fmu.projetoaula.util.ActivityUtil;

public class SignUpActivity extends AppCompatActivity {

    private EditText editTextUser;
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonRegister;

    private TextView textViewUserInfo;
    private TextView textViewNameInfo;
    private TextView textViewEmailInfo;
    private TextView textViewPasswordInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        this.editTextUser = findViewById(R.id.editTextSignUpUsername);
        this.editTextName = findViewById(R.id.editTextSignUpName);
        this.editTextEmail = findViewById(R.id.editTextSignUpEmail);
        this.editTextPassword = findViewById(R.id.editTextSignUpPassword);
        this.buttonRegister = findViewById(R.id.buttonSignUp);

        editTextUser.addTextChangedListener(getTextWatcher(editTextUser, textViewUserInfo));
        editTextName.addTextChangedListener(getTextWatcher(editTextName, textViewNameInfo));
        editTextEmail.addTextChangedListener(getTextWatcher(editTextEmail, textViewEmailInfo));
        editTextPassword.addTextChangedListener(getTextWatcher(editTextEmail, textViewPasswordInfo));

        updateAll();
    }

    public void back(View view) {
        ActivityUtil.openActivity(this, MainActivity.class);
    }

    private void updateAll() {
        final EditText[] editTexts = {editTextUser, editTextName, editTextEmail, editTextPassword};
        final TextView[] textViews = {textViewUserInfo, textViewNameInfo, textViewEmailInfo, textViewPasswordInfo};

        for (int i = 0; i < editTexts.length; i++) {
            final EditText editText = editTexts[i];
            final TextView textView = textViews[i];

            final Editable text = editText.getText();
            if (!text.toString().isEmpty()) {
                editText.setBackgroundColor(0);
                textView.setText(null);
            } else {
                editText.setBackgroundColor(Color.argb(75, 255, 0, 0));
                textView.setText(R.string.textRequiredText);
            }
        }

    }

    private TextWatcher getTextWatcher(@NotNull EditText editText, @NotNull TextView textView) {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateAll();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };
    }

}