package es.iespto.agl.dosier1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Practica22 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practica_22_activity);
        Button btn = (Button) findViewById(R.id.btnBuscar_22);
        btn.setOnClickListener(
                view -> {
                    search();
                }
        );
    }

    private void search() {
        EditText txtUrl = findViewById(R.id.txtUrl22);
        String txt = txtUrl.getText().toString();

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://"+txt));
        startActivity(intent);
    }
}
