package es.iespto.agl.dosier1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Practica23 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practica_23_24_activity);

        Button btnC = (Button) findViewById(R.id.btnCalculator23);
        btnC.setOnClickListener(
            view -> {
                Intent intent = new Intent(getApplicationContext(),Practica20.class);
                startActivity(intent);
            }
        );

        Button btnD = (Button) findViewById(R.id.btnDescomp);
        btnD.setOnClickListener(
            view -> {
                Intent intent = new Intent(getApplicationContext(),Practica23_2.class);
                startActivity(intent);
            }
        );
    }
}
