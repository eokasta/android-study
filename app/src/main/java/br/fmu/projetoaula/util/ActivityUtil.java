package br.fmu.projetoaula.util;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

public class ActivityUtil {

    public static void openActivity(
            @NotNull AppCompatActivity activity,
            @NotNull Class<? extends AppCompatActivity> clazz
    ) {
        final Intent intent = new Intent(activity, clazz);
        activity.startActivity(intent);
    }

}
