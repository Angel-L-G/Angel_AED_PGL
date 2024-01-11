package es.iespto.agl.dosier1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn0 = (Button)findViewById(R.id.btn0);
        //btn0.setOnClickListener(llamar());
    }

    public void llamar(View view){

    }
}



