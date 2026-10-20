package com.example.cyklzyciaaktywnosci3ptgr2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button buttonPlus,buttonMinus;
    TextView textView;
    int punkty = 0;

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
        if (savedInstanceState != null){
            punkty = savedInstanceState.getInt("PUNKTY", 0);

        }

        buttonPlus = findViewById(R.id.button);
        buttonMinus = findViewById(R.id.button2);
        textView  = findViewById(R.id.texViewPunkty);
        textView.setText(String.valueOf(punkty));
        buttonPlus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        punkty++;
//                        textView.setText(String.valueOf(punkty));
//                        textView.setText(Integer.toString(punkty));
                        textView.setText(punkty+"");
                    }
                }
        );

        buttonMinus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        punkty--;
                        textView.setText(punkty+"");
                    }
                }
        );
        Log.i("czas","wywołana metoda on create");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("czas","wywołana metoda on onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("czas","wywołana metoda on onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("czas","wywołana metoda on onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("czas","wywołana metoda on onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("czas","wywołana metoda on onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("czas","wywołana metoda on onDestroy");
    }
    // nie wolno wywolywac metod cyklu zycia
    //https://developer.android.com/guide/components/activities/activity-lifecycle?hl=pl

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("czas","wywołana metoda on onSaveInstanceState");
        outState.putInt("PUNKTY",punkty);
    }
}