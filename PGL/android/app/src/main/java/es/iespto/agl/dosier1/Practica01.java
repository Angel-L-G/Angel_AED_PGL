package es.iespto.agl.dosier1;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Practica01 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practica_01_activity);
        Toast.makeText(getApplicationContext(), "onCreate() call", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        setContentView(R.layout.practica_01_activity);
        Toast.makeText(getApplicationContext(), "onResume() call", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart(){
        super.onStart();
        setContentView(R.layout.practica_01_activity);
        Toast.makeText(getApplicationContext(), "onStart() call", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        setContentView(R.layout.practica_01_activity);
        Toast.makeText(getApplicationContext(), "onPause() call", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        setContentView(R.layout.practica_01_activity);
        Toast.makeText(getApplicationContext(), "onStop() call", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        setContentView(R.layout.practica_01_activity);
        Toast.makeText(getApplicationContext(), "onDestroy() call", Toast.LENGTH_SHORT).show();
    }
}
