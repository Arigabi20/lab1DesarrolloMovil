package com.example.holamundo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    Button boton2 = null;
    EditText box = null;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        showLog("Activity Created");
        box = findViewById(R.id.cajaNum);

        boton2 = findViewById(R.id.button);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private static final String HOME_ACTIVITY_TAG = MainActivity2.class.getSimpleName();

    private void showLog(String text) {
        Log.d(HOME_ACTIVITY_TAG, text);
    }


    @Override

    protected void onRestart() {

        super.onRestart();
        box.setText("1");
        showLog("Activity restarted");

    }

    @Override

    protected void onStart() {

        super.onStart();

        showLog("Activity started");


    }

    @Override

    protected void onResume() {

        super.onResume();

        showLog("Activity resumed");

    }

    @Override

    protected void onPause() {

        super.onPause();

        showLog("Activity paused");
        box.setText("");

    }

    @Override

    protected void onStop() {

        super.onStop();

        showLog("Activity stopped");

    }

    @Override

    protected void onDestroy() {

        super.onDestroy();

        showLog("Activity is being destroyed");

    }

}