package com.example.javalifecycle;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "Первый запуск!";
        } else {
            instanceState = "Повторный запуск!";
        }
        //Toast.makeText(this, instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();
        makeToastAndLog(instanceState + " - onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
        makeToastAndLog("onStart()");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        //Toast.makeText(getApplicationContext(), "Повторный запуск!! - onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
        makeToastAndLog("Повторный запуск!! - onRestoreInstanceState()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
        makeToastAndLog("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
        makeToastAndLog("onPause()");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        //Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
        makeToastAndLog("onSaveInstanceState()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
        makeToastAndLog("onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
        makeToastAndLog("onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
        makeToastAndLog("onDestroy()");
    }


    private void makeToastAndLog(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        Log.d(TAG, message);
    }
}
