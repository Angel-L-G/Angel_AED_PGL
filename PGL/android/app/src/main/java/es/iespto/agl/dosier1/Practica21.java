package es.iespto.agl.dosier1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Practica21 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practica_21_activity);

        Button btnC = (Button)findViewById(R.id.btnCall_21);
        btnC.setOnClickListener(
            view -> {
                call();
            }
        );

        Button btnG = (Button)findViewById(R.id.btnGoogle_21);
        btnG.setOnClickListener(
            view -> {
                search();
            }
        );

        Button btnL = (Button)findViewById(R.id.btnLocation_21);
        btnL.setOnClickListener(
            view -> {
                location();
            }
        );
    }

    private void call (){
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            // Si ya tienes el permiso, realiza la llamada
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:555-555-555"));
            startActivity(intent);
        } else {
            // Si no tienes el permiso, solicítalo al usuario
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CALL_PHONE}, 1);
        }
    }

    private void search (){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.google.com"));
        startActivity(intent);
    }

    private void location (){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?z=4&q;=restaurantes"));
        startActivity(intent);
    }
}
