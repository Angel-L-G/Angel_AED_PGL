package es.iespto.agl.dosier1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Practica19 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practica_19_activity);
        Button btn = (Button)findViewById(R.id.btnCalculate19);
        btn.setOnClickListener(
            view -> {
                calcular();
            }
        );
    }

    private void calcular(){
        EditText input = findViewById(R.id.inputNum_19);

        int num = Integer.parseInt(input.getText().toString());

        String res = "";

        for (int i = 0; i < 10; i++) {
            res+= num+ " * "+ i+ " = "+ (num*i)+ "\n";
        }

        TextView txtResults = findViewById(R.id.txtResults19);
        txtResults.setText(res);
    }
}
