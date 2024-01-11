package es.iespto.agl.dosier1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Practica26 extends AppCompatActivity {
    ArrayList<Integer> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practica_26_activity);

        datos = new ArrayList<Integer>();

        Button btn = (Button)findViewById(R.id.btnCrear);
        EditText txtResults = (EditText)findViewById(R.id.txtResults);

        btn.setOnClickListener(v ->{
            int aleatorio = (int) (Math.random()*100);
            datos.add(aleatorio);
            txtResults.setText(datos.toString());
        });
    }
}
