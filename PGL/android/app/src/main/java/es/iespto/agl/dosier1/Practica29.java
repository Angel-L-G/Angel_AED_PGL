package es.iespto.agl.dosier1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class Practica29 extends AppCompatActivity {
    int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practica_29_activity);
        Button btn = findViewById(R.id.btnChange29);
        btn.setOnClickListener(new View.OnClickListener() {
            Fragment f = null;
            @Override
            public void onClick(View v) {
                contador++;
                if(contador % 2 == 0){
                    f = new Practica29_Frag();
                }else{
                    f = new Practica29_Frag2();
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragContainer29, f)
                        .commit();
            }
        });
    }
}
