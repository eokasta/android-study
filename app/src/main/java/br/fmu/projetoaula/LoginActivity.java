package br.fmu.projetoaula;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import br.fmu.projetoaula.model.UserModel;
import br.fmu.projetoaula.registry.UserRegistry;
import br.fmu.projetoaula.util.ActivityUtil;

public class LoginActivity extends AppCompatActivity {

    private EditText userEditText;
    private EditText passwordEditText;
    private TextView responseTextView;
    private TextView userResponseTextView;
    private TextView passwordResponseTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.userEditText = findViewById(R.id.editTextUser);
        this.passwordEditText = findViewById(R.id.editTextPassword);
        this.responseTextView = findViewById(R.id.textViewResponse);
        this.userResponseTextView = findViewById(R.id.textViewUserResponse);
        this.passwordResponseTextView = findViewById(R.id.textViewPasswordResponse);

        userEditText.addTextChangedListener(getTextWatcher(userEditText, userResponseTextView));
        passwordEditText.addTextChangedListener(getTextWatcher(passwordEditText, passwordResponseTextView));
    }

    public void back(View view) {
        ActivityUtil.openActivity(this, MainActivity.class);
    }

    public void login(View view) {
        final String user = userEditText.getText().toString();
        final String password = passwordEditText.getText().toString();

        final int redColor = Color.argb(75, 255, 0, 0);
        if (user.isEmpty()) {
            userEditText.setBackgroundColor(redColor);
            userResponseTextView.setText(R.string.textRequiredText);
            return;
        } else {
            userEditText.setBackgroundColor(0);
            userResponseTextView.setText(null);
        }

        if (password.isEmpty()) {
            passwordEditText.setBackgroundColor(redColor);
            passwordResponseTextView.setText(R.string.textRequiredText);
            return;
        } else {
            passwordEditText.setBackgroundColor(0);
            passwordResponseTextView.setText(null);
        }

        final UserModel userModel = UserRegistry.USERS.get(user);
        if (userModel == null) {
            responseTextView.setText(R.string.textUserNotFound);
            return;
        }

        if (!password.equals(userModel.getPassword())) {
            responseTextView.setText(R.string.textWrongPassword);
            return;
        }

        responseTextView.setText(R.string.textLoginSuccessfully);
    }

    private TextWatcher getTextWatcher(@NotNull EditText editText, @NotNull TextView textView) {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    editText.setBackgroundColor(0);
                    textView.setText(null);
                } else {
                    editText.setBackgroundColor(Color.argb(75, 255, 0, 0));
                    textView.setText(R.string.textRequiredText);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };
    }

}
