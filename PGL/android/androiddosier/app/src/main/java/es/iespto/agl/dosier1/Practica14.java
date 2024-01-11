package es.iespto.agl.dosier1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Practica14 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practica_14_activity);
        Button btn = (Button)findViewById(R.id.btnCalculate);
        btn.setOnClickListener(
            view -> {
                calcular();
            }
        );
    }

    private void calcular(){
        TextView txtResults = findViewById(R.id.txtResults14);

        EditText input1 = findViewById(R.id.inputNum1_14);
        EditText input2 = findViewById(R.id.inputNum2_14);

        int num1 = Integer.parseInt(input1.getText().toString());
        int num2 = Integer.parseInt(input2.getText().toString());

        int res = num1+num2;

        txtResults.setText(res+"");
    }

}
