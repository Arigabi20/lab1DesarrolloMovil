package com.example.holamundo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button botonImp = null;
    EditText mensaje = null;
    CheckBox checkbbox = null;

    CalendarView calendario = null;
    String fecha = "";
    ImageButton botonImg = null;
    String mensajemsg = "";

    @SuppressLint({"MissingInflatedId","SimpleDateFormat"})
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


        SimpleDateFormat formatoFecha = new SimpleDateFormat("HH:mm");
        String hora = formatoFecha.format(new Date());

        botonImp = findViewById(R.id.btnHola);
        mensaje = findViewById(R.id.textView);
        checkbbox = findViewById(R.id.checkBox);
        botonImg = (ImageButton) findViewById(R.id.imageButton);

        calendario = findViewById(R.id.calendarView);
        long eventOccursOn = calendario.getDate();
        Date temporary = new Date(eventOccursOn);
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");


        botonImp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mensajemsg += " "+ mensaje.getText();
                mensajemsg += ", "+ checkbbox.isChecked();
                mensajemsg += ", "+hora;
                mensajemsg += ", "+ fecha;
                Toast.makeText(getApplicationContext(), mensajemsg, Toast.LENGTH_LONG).show();

                mensajemsg = "";
                //Snackbar snackbar = Snackbar.make(v, "This is Simple Snackbar, " + miFecha, Snackbar.LENGTH_SHORT);
                //snackbar.show();
                Snackbar snack = Snackbar.make(v, "Hola Mundo! Esta es la clase de Desarrollo Movil"
                        , Snackbar.LENGTH_LONG);
                snack.show();

            }
        });

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // display the selected date by using a toast
                fecha = dayOfMonth + "/" + (month+1) + "/" + year;
                //Toast.makeText(getApplicationContext(), dayOfMonth + "/" + (month+1) + "/" + year, Toast.LENGTH_LONG).show();
            }
        });

        botonImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent puente = new Intent(getApplicationContext()
                        , MainActivity2.class);
                startActivity(puente);
            }
        });

    }
}